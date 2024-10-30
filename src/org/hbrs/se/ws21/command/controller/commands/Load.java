package org.hbrs.se.ws21.command.controller.commands;

import java.io.PrintStream;
import java.util.Scanner;
import org.hbrs.se.ws21.command.model.MitarbeiterContainer;
import org.hbrs.se.ws21.command.view.ConsoleUI;

public class Load extends ContainerCommand {

  public Load() {
    this(System.out, new Scanner(System.in), MitarbeiterContainer.getInstance());
  }

  public Load(PrintStream outstream, Scanner instream, MitarbeiterContainer mitarbeiterContainer) {
    this.outstream = outstream;
    this.input = instream;
    this.speicher = mitarbeiterContainer;
  }

  @Override
  public void execute() {
    // TODO: Streams beheben in commands
    String parameter = new ConsoleUI(super.outstream).loadDialogue(input);
    try {
      if (parameter.equals("merge")) {
        speicher.merge();
      } else {
        speicher.force();
      }
      // We do not need a boolean because an exception
      // in merge() or force() would skip this line.
      new ConsoleUI(super.outstream).displayLoadSucessMessage();
    } catch (Exception e) {
      new ConsoleUI(super.outstream).displayLoadFailureMessage(e);
    }
  }
}
