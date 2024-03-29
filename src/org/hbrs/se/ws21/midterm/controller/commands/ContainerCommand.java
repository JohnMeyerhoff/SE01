package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;
import java.util.Scanner;
import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;

public abstract class ContainerCommand implements Command {

  protected PrintStream outstream;
  protected Scanner input;
  protected MitarbeiterContainer speicher; // singleton

  @SuppressWarnings({"java:S106"})
  protected ContainerCommand() {
    this(System.out, new Scanner(System.in), MitarbeiterContainer.getInstance());
  }

  protected ContainerCommand(PrintStream outstream, Scanner instream,
      MitarbeiterContainer mitarbeiterContainer) {
    this.outstream = outstream;
    this.input = instream;
    this.speicher = (mitarbeiterContainer != null) ? mitarbeiterContainer
        : MitarbeiterContainer.getInstance();
  }
}
