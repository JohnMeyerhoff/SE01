package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;
import java.util.Scanner;

import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.model.SprintContainer;
import org.hbrs.se.ws21.midterm.model.persistence.PersistenceStrategyStream;
import org.hbrs.se.ws21.midterm.view.ConsoleUI;

public class Load extends ContainerCommand {
    public Load() {
        this(System.out, new Scanner(System.in), MitarbeiterContainer.getInstance());
    }

    public Load(PrintStream outstream, Scanner instream,
            MitarbeiterContainer mitarbeiterContainer) {
        this.outstream = outstream;
        this.input = instream;
        this.speicher = mitarbeiterContainer;
    }

    @Override
    public void execute() {
        // The loading method uses the already set strategies of the singleton
        // instances.
        // the constructor could be updated to make sure there is a reference of the
        // container type
        // this reference would also have to be not null to make sure whoever creates
        // the loadcommand has access
        // to an existing container and therefore could set its strategies.
        String parameter = new ConsoleUI(super.outstream).loadDialogue(input);
        try {
            if (parameter.equals("merge")) {
                SprintContainer.getInstance().merge();
                speicher.merge();
            } else {
                SprintContainer.getInstance().force();
                speicher.force();
            }
            // We do not need a boolean because an exception
            // in merge() or force()would skip this line.
            new ConsoleUI(super.outstream).displayLoadSucessMessage();
        } catch (Exception e) {
            new ConsoleUI(super.outstream).displayLoadFailureMessage(e);
        }
    }

}
