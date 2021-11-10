package org.hbrs.se.ws21.uebung4.controller;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.
import java.util.Scanner;
import java.util.stream.Collectors;

import org.hbrs.se.ws21.uebung4.model.Expertise;
import org.hbrs.se.ws21.uebung4.model.Mitarbeiter;
import org.hbrs.se.ws21.uebung4.model.MitarbeiterContainer;
import org.hbrs.se.ws21.uebung4.model.exception.ContainerException;
import org.hbrs.se.ws21.uebung4.model.exception.PersistenceException;
import org.hbrs.se.ws21.uebung4.view.ConsoleUI;
import org.hbrs.se.ws21.uebung4.view.MemberView;

public class Client {

    public int konsole(MitarbeiterContainer speicher, Scanner eingabe,
            PrintStream outstream) throws PersistenceException {

        String tmp;
        MemberView a = new MemberView(outstream);
        ConsoleUI ui = new ConsoleUI(outstream);
        ui.displayWelcomeMessage();

        while (eingabe.hasNext()) {
            boolean validcommand = false;
            tmp = eingabe.next();
            if (tmp.equals("exit")) {
                ui.displayGoodBye();
                eingabe.close(); // Schliessen des Scanners
                return 0;
            }

            if (tmp.equals("help")) {
                validcommand = true;
                ui.displayHelpMessage();
            }

            if (tmp.equals("store")) {
                validcommand = true;
                MitarbeiterContainer.getInstance().store();
            }

            if (tmp.equals("dump")) {
                validcommand = true;
                if (speicher.size() == 0) {
                    ui.displayNothingFoundTable();
                } else {
                    String abteilungsfilter = ui.textonlyDialogue(eingabe,
                            "den Abteilungsnamen (* für alle)");
                    // * Gibt die Mitarbeiter aller Abteilungen ungefiltert zurück.

                    //nochmal besprechen:
                    if (abteilungsfilter.equals("*")) {
                        a.dumpSorted(
                                MitarbeiterContainer.getInstance().getCurrentListCopy());
                    } else {
                        a.dumpAbteilung(
                                MitarbeiterContainer.getInstance().getCurrentListCopy(),
                                abteilungsfilter);
                    }
                }
            }

            if (tmp.equals("load")) {
                validcommand = true;
                String parameter = ui.loadDialogue(eingabe);
                try {
                    if (parameter.equals("merge")) {
                        speicher.merge();
                    } else {
                        speicher.force();
                    }
                    // We do not need a boolean because an exception
                    // in merge() would skip this line.
                    ui.displayLoadSucessMessage();
                } catch (Exception e) {
                    ui.displayLoadFailureMessage(e);
                }
            }
            // bergeunzung der zeichen noch ggf. anpassen!
            if (tmp.equals("enter")) {
                validcommand = true;
                String vorname = ui.textonlyDialogue(eingabe, "ihren Vornamen");
                String name = ui.textonlyDialogue(eingabe, "ihren Nachnamen");
                String rolle = ui.textonlyDialogue(eingabe, "ihre Rolle");
                String abteilung = ui.textonlyDialogue(eingabe, "ihre Abteilung");
                Expertise ax = new Expertise(); 
                for (int i = 0; i < 3; i++) {
                    if (i == 2) {
                        outstream.println("Dies ist Ihr letzter Eintrag als "
                                + "Fähigkeit, da Sie hier nur 3 Ihrer besten Fähigkeiten angeben können. ");
                    }
                    outstream.println(
                            "Bitte geben Sie Ihre Fähigkeit oder Expertise in einem Wort an.  \n  Wenn Sie keine weitere Fähigkeit haben, dann geben sie bitte '-' ein.");
                    String faehigkeit = eingabe.next();
                    if (faehigkeit.equals("-")) {
                        break;
                    }
                    outstream.println(
                            "Welches Level besitzen Sie in dieser Fähigkeit? + \n +Bitte geben Sie das Level als Zahl zwischen 1 bis 3 an. +\n+ 1 wäre Beginner, 2 wäre Experte und 3 wäre Top-Performer.");
                    int lvl = eingabe.nextInt();
                    while (lvl < 1 || lvl > 3) {
                        outstream.println(
                            "Falsche Eingabe. Sie können nur Level von 1 bis 3 angeben.");
                            lvl = eingabe.nextInt();
                        
                    }
                    ax.putFaehigkeitLvl(faehigkeit, lvl);
                }

                Mitarbeiter x = new Mitarbeiter(vorname, name, rolle, abteilung, ax);
                try {
                    speicher.addMember(x);
                } catch (ContainerException e) {
                    outstream.println("Abspeichern Fehlgeschlagen.");
                }
            }
            if (tmp.equals("search")) {
                validcommand = true;
                String fertigkeit = ui.searchDialogue(eingabe);
                List<Mitarbeiter> x = speicher.getCurrentListCopy().stream().filter(
                        ma -> ma.getExpertise().getErfahrungen().containsKey(fertigkeit))
                        .toList();
                if (x.isEmpty()) {
                    ui.displayExpertiseNotFound();
                } else {
                    ui.displayExpertiseFound(fertigkeit);
                }
                a.dumpSearched(x, fertigkeit);
            }

            /** 
             * Validcommand setzt sich zu beginn jedes Commands Neu auf False, und
             * innerhalb der einzelnen Befehle Auf true. Die InvalidCommandMessage wird
             * nur ausgegeben wenn !FALSE == True also validcommand == false
             */
            if (!validcommand) {
                ui.displayInvalidCommandMessage();
            }

        }
        return 5; // Eingabe beendet ohne exit
    }

}
