package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;

import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.model.exception.PersistenceException;

public class Store extends ConsoleCommand {
    @SuppressWarnings({ "java:S106" })
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
