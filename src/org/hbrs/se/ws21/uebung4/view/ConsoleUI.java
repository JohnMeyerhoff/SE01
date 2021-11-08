package org.hbrs.se.ws21.uebung4.view;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleUI {
    PrintStream out;

    public ConsoleUI(PrintStream out) {
        this.out = out;
    }

    public void displayWelcomeMessage() {
        out.println("Willkommen im Sprint-Tool von Klara und John,"
                + " \nmit dem Befehl help erhalten Sie eine Übersicht.\n>");
    }

    public void displayHelpMessage() {
        out.println("Mögliche Befehle für Sie sind: \nenter \nstore \nload"
                + "\ndump \nsearch \nexit \nhelp \n");
    }

    public void displayGoodBye() {
        out.println("Auf Wiedersehen");
    }

    public void displayNothingFoundTable() {
        out.println("+--------------------------+");
        out.println("|Keine Mitarbeiter Gefunden|");
        out.println("+--------------------------+");
    }

    public void displayLoadSucessMessage() {
        out.println("Erfolgreich geladen.");
    }

    public void displayExpertiseNotFound() {
        out.println("Leider wurden keine Mitarbeiter mit dieser Expertise gefunden.");
    }

    public void displayExpertiseFound(String fertigkeit) {
        out.println("Folgende Mitarbeiter haben die Expertise " + fertigkeit + ":\n");

    }

    public void displayInvalidCommandMessage() {
        out.println("Ihre Eingabe war kein gültiger Befehl. " + "\n"
                + "Sie können 'help' als Befehl eingeben, um alle Möglichkeiten zu sehen.");
    }

    public String loadDialogue(Scanner input) {
        out.println("Bitte angeben, ob mit merge oder force geladen wird.");
        while(input.hasNext()){
            String tmp = input.next();
            if (tmp.equalsIgnoreCase("merge")|| tmp.equalsIgnoreCase("force")){
                return tmp;
            }else{
                out.println("Bitte geben sie hier nur 'merge' oder 'force' ein.");
            }
        }
        return "force";
    }

    public String searchDialogue(Scanner suche) {
        out.println("Bitte geben Sie eine von Ihnen gesuchte Expertise an. ");     
        return suche.next();
    }

    public void displayLoadFailureMessage(Exception e) {
        /**
         * TODO: e instanceof zum verbessern der präzision
         */
        out.println("Das laden war nicht erfolgreich.");
    }

    /**
     * 
     * @param input
     * @param label takes the label to
     * be placed in the format of
     * __Bitte geben Sie "+label+" ein.__
     * @return
     */
	public String textonlyDialogue(Scanner input,String label) {
		
        out.println("Bitte geben Sie "+label+" ein. ");
        Pattern p = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
        while(input.hasNext()){
            String tmp = input.next();
            Matcher m = p.matcher(tmp);
            if (m.find()){
                out.println("Bitte geben sie hier nur Buchstaben ein.");
            }else{
                return tmp;
            }
        }
        return "Fehler";
	}

}
