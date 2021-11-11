package org.hbrs.se.ws21.command.controller.commands;

import java.io.PrintStream;

import org.hbrs.se.ws21.command.view.ConsoleUI;

public class Exit extends ConsoleCommand {
    public Exit() {
        this(System.out);
    }

    public Exit(PrintStream outstream) {
        this.outstream = outstream;
    }

    @Override
    public void execute() {
        new ConsoleUI(super.outstream).displayGoodBye();
    }

}
