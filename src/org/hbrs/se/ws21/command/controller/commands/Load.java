package org.hbrs.se.ws21.command.controller.commands;

import java.io.PrintStream;

import org.hbrs.se.ws21.command.view.ConsoleUI;

public class Load extends ConsoleCommand {
    public Load() {
        // TODO: PARAMETER HINZUFÜGEN
        this(System.out);
    }

    public Load(PrintStream outstream) {
        this.outstream = outstream;
    }

    @Override
    public void execute() {
        // TODO: Streams beheben in commands
        String parameter = new ConsoleUI(super.outstream).loadDialogue(eingabe);
        try {
            if (parameter.equals("merge")) {
                speicher.merge();
            } else {
                speicher.force();
            }
            // We do not need a boolean because an exception
            // in merge() would skip this line.
            new ConsoleUI(super.outstream).displayLoadSucessMessage();
        } catch (Exception e) {
            new ConsoleUI(super.outstream).displayLoadFailureMessage(e);
        }
    }

}
