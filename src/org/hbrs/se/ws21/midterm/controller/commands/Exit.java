package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;

import org.hbrs.se.ws21.midterm.view.ConsoleUI;

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
