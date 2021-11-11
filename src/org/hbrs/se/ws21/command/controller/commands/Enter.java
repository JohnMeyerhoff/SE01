package org.hbrs.se.ws21.command.controller.commands;

import java.io.PrintStream;

import org.hbrs.se.ws21.command.view.ConsoleUI;

public class Enter extends ConsoleCommand {
    public Enter() {
        this(System.out);
    }

    public Enter(PrintStream outstream) {
        this.outstream = outstream;
    }

    @Override
    public void execute() {
        new ConsoleUI(super.outstream).displayWelcomeMessage();
    }

}
