package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;

import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.model.SprintContainer;
import org.hbrs.se.ws21.midterm.view.ConsoleUI;
import org.hbrs.se.ws21.midterm.view.MitarbeiterView;
import org.hbrs.se.ws21.midterm.view.SprintView;

public class Show extends ContainerCommand {

    public Show(PrintStream outstream) {
        this.outstream = outstream;
    }

    @Override
    public void execute() {

        ConsoleUI ui = new ConsoleUI(outstream);
        SprintContainer sprints = SprintContainer.getInstance();
        MitarbeiterContainer mitarbeiter = MitarbeiterContainer.getInstance();

        ui.vspace(1);
        if (sprints.size() == 0) {
            ui.displayNothingFoundTable("Sprints ");
        } else {
            new SprintView()
                    .dumpSorted(sprints.getCurrentListCopy());

        }
        ui.vspace(2);
        if (mitarbeiter.size() == 0) {
            ui.displayNothingFoundTable("Mitarbeietr ");
        } else {
            new MitarbeiterView()
                    .dumpSorted(mitarbeiter.getCurrentListCopy());

        }

    }

}
