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
import org.hbrs.se.ws21.command.controller.commands.Enter;
import org.hbrs.se.ws21.command.controller.commands.Help;
import org.hbrs.se.ws21.command.controller.commands.Load;
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
        this.executables = Map.ofEntries(
            entry("help", new Help(outstream)),
            entry("load", new Load(outstream, eingabe, speicher)),
            entry("enter", new Enter(outstream, eingabe, speicher)),
            entry("store", new Store(outstream))
            );
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

            
            // bergeunzung der zeichen noch ggf. anpassen!
            
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
