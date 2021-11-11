package org.hbrs.se.ws21.command.controller.commands;

import java.io.PrintStream;

import org.hbrs.se.ws21.command.view.ConsoleUI;

public class Dump extends ConsoleCommand {
    public Dump() {
        this(System.out);
    }

    public Dump(PrintStream outstream) {
        this.outstream = outstream;
    }

    @Override
    public void execute() {
        new ConsoleUI(super.outstream).displayWelcomeMessage();
    }

}
