package org.hbrs.se.ws21.command.controller;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.
import java.util.Scanner;
import static java.util.Map.entry;

import org.hbrs.se.ws21.command.controller.commands.Command;
import org.hbrs.se.ws21.command.controller.commands.Help;
import org.hbrs.se.ws21.command.controller.commands.Store;
import org.hbrs.se.ws21.command.controller.commands.WrongCommand;
import org.hbrs.se.ws21.command.model.Expertise;
import org.hbrs.se.ws21.command.model.Mitarbeiter;
import org.hbrs.se.ws21.command.model.MitarbeiterContainer;
import org.hbrs.se.ws21.command.model.exception.ContainerException;
import org.hbrs.se.ws21.command.model.exception.PersistenceException;
import org.hbrs.se.ws21.command.view.ConsoleUI;
import org.hbrs.se.ws21.command.view.MemberView;

public class Client {
    Command defaultCommand;
    private MitarbeiterContainer speicher;
    private Scanner eingabe;
    private PrintStream outstream;
    private Map<String, Command> executables;

    public Client(MitarbeiterContainer speicher, Scanner eingabe, PrintStream outstream) {
        this.speicher = speicher;
        this.eingabe = eingabe;
        this.outstream = outstream;
        this.defaultCommand = new WrongCommand(this.outstream);
        this.executables = Map.ofEntries(entry("help", new Help(outstream)), entry("store", new Store(outstream)));
    }

    public int konsole() {

        String tmp;
        MemberView a = new MemberView(outstream);
        ConsoleUI ui = new ConsoleUI(outstream);
        ui.displayWelcomeMessage();

        while (eingabe.hasNext()) {
            tmp = eingabe.next();
            this.executables.getOrDefault(tmp, this.defaultCommand).execute();
            if (tmp.equals("exit")) {
                eingabe.close(); // Schliessen des Scanners
                return 0;
            }

            if (tmp.equals("load")) {
                // TODO: Streams beheben in commands
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
                // TODO: Streams beheben in commands
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
                        outstream.println("Falsche Eingabe. Sie können nur Level von 1 bis 3 angeben.");
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
                // TODO: Streams beheben in commands
                String fertigkeit = ui.searchDialogue(eingabe);
                List<Mitarbeiter> x = speicher.getCurrentListCopy().stream()
                        .filter(ma -> ma.getExpertise().getErfahrungen().containsKey(fertigkeit)).toList();
                if (x.isEmpty()) {
                    ui.displayExpertiseNotFound();
                } else {
                    ui.displayExpertiseFound(fertigkeit);
                }
                a.dumpSearched(x, fertigkeit);
            }

        }
        return 5; // Eingabe beendet ohne exit
    }

}
