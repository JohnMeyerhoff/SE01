package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;

import org.hbrs.se.ws21.midterm.view.ConsoleUI;

public class Help extends ConsoleCommand {
    public Help() {
        this(System.out);
    }

    public Help(PrintStream outstream) {
        this.outstream = outstream;
    }

    @Override
    public void execute() {
        new ConsoleUI(super.outstream).displayWelcomeMessage();
    }

}
