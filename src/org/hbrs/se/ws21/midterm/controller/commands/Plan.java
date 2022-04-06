package org.hbrs.se.ws21.midterm.controller.commands;

import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.model.SprintContainer;
import org.hbrs.se.ws21.midterm.view.ConsoleUI;
import org.hbrs.se.ws21.midterm.view.MitarbeiterView;
import org.hbrs.se.ws21.midterm.view.SprintView;

import java.io.PrintStream;
import java.util.Scanner;

public class Plan extends ContainerCommand{

    public Plan(PrintStream outstream, Scanner eingabe, MitarbeiterContainer speicher) {
        super.outstream = outstream;
        super.input = eingabe;
        super.speicher = speicher;
    }

    @Override
    public void execute() {
        ConsoleUI ui = new ConsoleUI(outstream);
        SprintContainer sprints = SprintContainer.getInstance();
        MitarbeiterContainer mitarbeiter = speicher != null ? speicher : MitarbeiterContainer.getInstance();
        if (sprints.size() == 0) {
            ui.displayNothingFoundTable();
        } else {
            new SprintView()
                    .dumpSorted(sprints.getCurrentListCopy());
            if (mitarbeiter.size() == 0) {
                ui.displayNothingFoundTable();
            } else {
                new MitarbeiterView()
                        .dumpSorted(mitarbeiter.getCurrentListCopy());


            }

        }
    }
}
