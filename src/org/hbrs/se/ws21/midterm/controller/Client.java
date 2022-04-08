package org.hbrs.se.ws21.midterm.controller;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;
import static java.util.Map.entry;

import org.hbrs.se.ws21.midterm.controller.commands.*;
import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.view.ConsoleUI;

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
        this.executables = Map.ofEntries(entry("help", new Help(outstream)),
                entry("load", new Load(outstream, eingabe, this.speicher)),
                entry("enter", new Enter(outstream, eingabe, this.speicher)),
                entry("dump", new Dump(outstream, eingabe)),
                entry("plan", new Plan(outstream, eingabe, this.speicher)),
                entry("search", new Search(outstream, eingabe, this.speicher)),
                entry("show", new Show(outstream)), entry("store", new Store(outstream)));
    }

    public int konsole() {

        String tmp;

        ConsoleUI ui = new ConsoleUI(outstream);
        ui.displayWelcomeMessage();

        while (eingabe.hasNext()) {
            tmp = eingabe.next();

            if (tmp.equals("exit")) {
                eingabe.close(); // Schliessen des Scanners
                return 0;
            }
            this.executables.getOrDefault(tmp, this.defaultCommand).execute();
            ui.promptWaitingForUserInput();
        }
        return 5; // Eingabe beendet ohne exit
    }

}
