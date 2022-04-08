package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;

public abstract class ConsoleCommand implements Command {

    protected PrintStream outstream;

    @SuppressWarnings({ "java:S106" })
    protected ConsoleCommand() {
        this(System.out);
    }

    protected ConsoleCommand(PrintStream outstream) {
        this.outstream = outstream;
    }

}
