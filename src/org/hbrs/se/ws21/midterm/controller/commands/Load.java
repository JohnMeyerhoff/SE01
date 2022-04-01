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
        // TODO: Streams beheben in commands
        String parameter = new ConsoleUI(super.outstream).loadDialogue(input);
        try {
            SprintContainer.getInstance().setStrategy(new PersistenceStrategyStream<>());
            SprintContainer.getInstance().load();
            if (parameter.equals("merge")) {
                speicher.merge();
            } else {
                speicher.force();
            }
            // We do not need a boolean because an exception
            // in merge() would skip this line.
            new ConsoleUI(super.outstream).displayLoadSucessMessage();
        } catch (Exception e) {
            new ConsoleUI(super.outstream).displayLoadFailureMessage(e);
        }
    }

}
