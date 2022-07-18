package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;
import org.hbrs.se.ws21.midterm.view.ConsoleUI;

public class WrongCommand extends ConsoleCommand {

  @SuppressWarnings({"java:S106"})
  public WrongCommand() {
    this(System.out);
  }

  public WrongCommand(PrintStream outstream) {
    this.outstream = outstream;
  }

  @Override
  public void execute() {
    new ConsoleUI(super.outstream).displayInvalidCommandMessage();
  }

}
