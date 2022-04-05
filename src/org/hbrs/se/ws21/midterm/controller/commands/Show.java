package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;

import org.hbrs.se.ws21.midterm.model.SprintContainer;
import org.hbrs.se.ws21.midterm.view.ConsoleUI;
import org.hbrs.se.ws21.midterm.view.SprintView;

public class Show extends ContainerCommand {

    public Show(PrintStream outstream) {
        this.outstream = outstream;
    }

    @Override
    public void execute() {

        ConsoleUI ui = new ConsoleUI(outstream);
        SprintContainer speicher = SprintContainer.getInstance();

        if (speicher.size() == 0) {
            ui.displayNothingFoundTable();
        } else {
            new SprintView()
                    .dumpSorted(SprintContainer.getInstance().getCurrentListCopy());

        }

    }

}
