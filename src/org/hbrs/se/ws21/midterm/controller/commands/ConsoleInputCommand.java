package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class ConsoleInputCommand implements Command {

    protected PrintStream outstream;
    protected Scanner input;

    @SuppressWarnings({ "java:S106" })
    protected ConsoleInputCommand() {
        this(System.out, new Scanner(System.in));
    }

    protected ConsoleInputCommand(PrintStream outstream, Scanner instream) {
        this.outstream = outstream;
        this.input = instream;
    }

}
