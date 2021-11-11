package org.hbrs.se.ws21.command.controller.commands;

import java.io.PrintStream;

import org.hbrs.se.ws21.command.view.ConsoleUI;

public class WrongCommand extends ConsoleCommand {
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
