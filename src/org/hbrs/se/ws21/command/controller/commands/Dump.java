package org.hbrs.se.ws21.command.controller.commands;

import java.io.PrintStream;
import java.util.Scanner;

import org.hbrs.se.ws21.command.model.MitarbeiterContainer;
import org.hbrs.se.ws21.command.view.ConsoleUI;
import org.hbrs.se.ws21.command.view.MemberView;

public class Dump extends ConsoleInputCommand {

    public Dump(PrintStream outstream, Scanner instream) {
        this.outstream = outstream;
        this.input = instream;
    }

    @Override
    public void execute() {

        ConsoleUI ui = new ConsoleUI(outstream);
        MitarbeiterContainer speicher = MitarbeiterContainer.getInstance();
        // TODO: Streams beheben in commands
        if (speicher.size() == 0) {
            ui.displayNothingFoundTable();
        } else {
            String abteilungsfilter = ui.textonlyDialogue(input,
                    "den Abteilungsnamen (* für alle)");
            // * Gibt die Mitarbeiter aller Abteilungen ungefiltert zurück.
            if (abteilungsfilter.equals("*")) {
                new MemberView().dumpSorted(
                        MitarbeiterContainer.getInstance().getCurrentListCopy());
            } else {
                new MemberView().dumpAbteilung(
                        MitarbeiterContainer.getInstance().getCurrentListCopy(),
                        abteilungsfilter);
            }
        }

    }

}
