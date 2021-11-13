package org.hbrs.se.ws21.command.controller.commands;

import java.io.PrintStream;

public abstract class ConsoleCommand implements Command {

    protected PrintStream outstream;

    protected ConsoleCommand() {
        this(System.out);
    }

    protected ConsoleCommand(PrintStream outstream) {
        this.outstream = outstream;
    }

}
