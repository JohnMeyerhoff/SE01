package org.hbrs.se.ws21.uebung4.view;

import java.io.PrintStream;
import java.util.Scanner;

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
        return input.next();
    }

}
