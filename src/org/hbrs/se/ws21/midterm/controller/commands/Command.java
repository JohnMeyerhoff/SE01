package org.hbrs.se.ws21.midterm.controller.commands;

public interface Command {
    /*
     * The call stack for undo should be implemented not here, but rather in an
     * abstract class called ReversibleCommand. At the moment only very specific
     * tasks could even be undone (e.g. adding a new Mitarbeiter).
     */
    public void execute();
}
