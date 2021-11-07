package org.hbrs.se.ws21.uebung4.controller;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
import java.util.Scanner;

import org.hbrs.se.ws21.uebung4.model.Expertise;
import org.hbrs.se.ws21.uebung4.model.Mitarbeiter;
import org.hbrs.se.ws21.uebung4.model.MitarbeiterContainer;
import org.hbrs.se.ws21.uebung4.model.persistence.PersistenceException;
import org.hbrs.se.ws21.uebung4.view.MemberView;

public class Client {
    Scanner suche = new Scanner(System.in);
    public int konsole(MitarbeiterContainer speicher) throws PersistenceException {
        String tmp;
        while (suche.hasNext()) {
            tmp = suche.next();
            if (tmp.equals("help")) {
                System.out.println("Mögliche Befehle für Sie sind: " + "\n" + "enter," + "\n" + "store," + "\n"
                        + "load," + "\n" + "dump," + "\n" + "search," + "\n" + "exit," + "\n" + "help" + "\n");
            }
            if (tmp.equals("exit")) {
                System.out.println("Auf Wiedersehen");
                return 0;
            }
            if (tmp.equals("store")) {
                MitarbeiterContainer.getInstance().store();
            }
            if (tmp.equals("load")) {
                String parameter = suche.next();
                try {
                    if (parameter.equals("merge")) {
                        speicher.merge();
                    } else {
                        speicher.force();
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Sie haben einen falschen Parameter angegeben.");
                }
            }

            if (tmp.equals("dump")) {
                MemberView a = new MemberView();
                a.dumpSorted(MitarbeiterContainer.getInstance().getCurrentListCopy());
            }

            // bergeunzung der zeichen noch ggf. anpassen!
            if (tmp.equals("enter")) {

                System.out.println("Bitte geben Sie ihren Vornamen ein. ");
                String vorname = suche.next();

                System.out.println("Bitte geben Sie ihren Nachname ein. ");
                String name = suche.next();

                for (int i = 0; i < 10; i++) {
                    // evtl noch nach Symbolen überprüfen!!
                    if (name.contains("" + i) || vorname.contains("" + i)) {
                        System.out.println(
                                "Ungültige Eingabe für Ihren Vor- bzw. Nachname.\nBitte versuchen Sie es nochmal.");
                        break; // damit if-statement abbricht - neuer Verscuh im nächsten Schleifendurchlauf
                    }
                }

                System.out.println("Bitte geben Sie ihre Rolle ein. ");
                String rolle = suche.next();
                
                System.out.println("Bitte geben Sie ihre Abteilung ein. ");
                String abteilung = suche.next();
                
                Expertise a = new Expertise();
                for (int i = 0; i < 3; i++) {
                    if (i == 2) {
                        System.out.println(
                                "Dies ist Ihr letzter Eintrag als Fähigkeit, da Sie hier nur 3 Ihrer besten Fähigkeiten angeben können. ");
                    }
                    System.out.println(
                            "Bitte geben Sie Ihre Fähigkeit oder Expertise in einem Wort an.  \n  Wenn Sie keine weitere Fähigkeit haben, dann geben sie bitte '-' ein.");
                    String faehigkeit = suche.next();
                    if (faehigkeit.equals("-")) {
                        break;
                    }
                    System.out.println(
                        "Welches Level besitzen Sie in dieser Fähigkeit? + \n +Bitte geben Sie das Level als Zahl zwischen 1 bis 3 an. +\n+ 1 wäre Beginner, 2 wäre Experte und 3 wäre Top-Performer.");
                        boolean gelesen = false;
                        while (!gelesen) {
                        try {
                            int lvl = suche.nextInt();
                            if(lvl < 1 || lvl > 3){
                                System.out.println("Falsche Eingabe. Sie können nur Level von 1 bis 3 angeben.");
                                gelesen = false; 
                                continue;
                            }
                            a.putFaehigkeitLvl(faehigkeit, lvl);
                            gelesen = true;
                        } catch (IllegalArgumentException falschesArgument) {
                            System.out.println(
                                    "Versuchen Sie es nocheinmal. Sie dürfen nur eine Zahl zwischen 1 bis 3 angeben.");
                            gelesen = false;
                        }
                    }
                }
                System.out.println(" ");
                Mitarbeiter x = new Mitarbeiter(vorname,name,rolle, abteilung, a);
                try {
                    speicher.addMember(x);
                } catch (ContainerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }            
            if (tmp.equals("search")) {

            }

            System.out.println("Sie haben keine der gegebenen Befehle benutzt. " + "\n"
                    + "Geben Sie 'help' als Befehl ein, um alle Möglichkeiten zu sehen.");

        }
        return 5; // Eingabe beendet ohne exit
    }

}