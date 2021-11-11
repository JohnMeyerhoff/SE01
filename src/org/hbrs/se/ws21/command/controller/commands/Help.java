package org.hbrs.se.ws21.command.controller.commands;

import org.hbrs.se.ws21.command.view.ConsoleUI;
import java.io.PrintStream;
public class Help implements Command {
    PrintStream outstream;
    public Help(){
        this(System.out);
    }
    public Help(PrintStream outstream){
        this.outstream = outstream;
    }

    public void execute(){
    new ConsoleUI(outstream).displayWelcomeMessage();
}

}


