package org.hbrs.se.ws21.midterm.controller;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

import static java.util.Map.entry;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;
import org.hbrs.se.ws21.midterm.controller.commands.Command;
import org.hbrs.se.ws21.midterm.controller.commands.Dump;
import org.hbrs.se.ws21.midterm.controller.commands.Enter;
import org.hbrs.se.ws21.midterm.controller.commands.Help;
import org.hbrs.se.ws21.midterm.controller.commands.Load;
import org.hbrs.se.ws21.midterm.controller.commands.Plan;
import org.hbrs.se.ws21.midterm.controller.commands.Search;
import org.hbrs.se.ws21.midterm.controller.commands.Show;
import org.hbrs.se.ws21.midterm.controller.commands.Store;
import org.hbrs.se.ws21.midterm.controller.commands.WrongCommand;
import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.view.ConsoleUI;

public class Client {

  Command defaultCommand;
  private final MitarbeiterContainer speicher;
  private final Scanner eingabe;
  private final PrintStream outstream;
  private final Map<String, Command> executables;

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
