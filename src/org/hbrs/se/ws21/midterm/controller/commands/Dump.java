package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;
import java.util.Scanner;
import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.view.ConsoleUI;
import org.hbrs.se.ws21.midterm.view.MitarbeiterView;

public class Dump extends ConsoleInputCommand {

  public Dump(PrintStream outstream, Scanner instream) {
    super.outstream = outstream;
    super.input = instream;
  }

  @Override
  public void execute() {

    ConsoleUI ui = new ConsoleUI(super.outstream);
    MitarbeiterContainer speicher = MitarbeiterContainer.getInstance();
    // TODO: Streams beheben in commands
    if (speicher.size() == 0) {
      ui.displayNothingFoundTable();
    } else {
      String abteilungsfilter = ui.textonlyDialogue(super.input,
          "den Abteilungsnamen (* für alle)");
      // * Gibt die Mitarbeiter aller Abteilungen ungefiltert zurück.

      // nochmal besprechen:
      if (abteilungsfilter.equals("*")) {
        new MitarbeiterView().dumpSorted(
            MitarbeiterContainer.getInstance().getCurrentListCopy());
      } else {
        new MitarbeiterView().dumpAbteilung(
            MitarbeiterContainer.getInstance().getCurrentListCopy(),
            abteilungsfilter);
      }
    }

  }

}
