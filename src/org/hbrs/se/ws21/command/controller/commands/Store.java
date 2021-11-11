package org.hbrs.se.ws21.command.controller.commands;

import java.io.PrintStream;

import org.hbrs.se.ws21.command.model.MitarbeiterContainer;
import org.hbrs.se.ws21.command.model.exception.PersistenceException;
import org.hbrs.se.ws21.command.view.ConsoleUI;

public class Store extends ConsoleCommand {
    public Store() {
        this(System.out);
    }

    public Store(PrintStream outstream) {
        this.outstream = outstream;
    }

    @Override
    public void execute() {
        try {
            MitarbeiterContainer.getInstance().store();
        } catch (PersistenceException e) {
           this.outstream.println("Es ist Fehler beim Speichern aufgetreten.");
        }
    }

}
