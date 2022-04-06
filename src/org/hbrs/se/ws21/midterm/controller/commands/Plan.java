package org.hbrs.se.ws21.midterm.controller.commands;

import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.model.Sprint;
import org.hbrs.se.ws21.midterm.model.SprintContainer;
import org.hbrs.se.ws21.midterm.view.ConsoleUI;
import org.hbrs.se.ws21.midterm.view.MitarbeiterView;
import org.hbrs.se.ws21.midterm.view.SprintView;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plan extends ContainerCommand {

    public Plan(PrintStream outstream, Scanner eingabe, MitarbeiterContainer speicher) {
        super.outstream = outstream;
        super.input = eingabe;
        super.speicher = speicher;
    }

    @Override
    public void execute() {
        ConsoleUI ui = new ConsoleUI(outstream);
        SprintContainer sprints = SprintContainer.getInstance();
        String sName = ui.textAndDigitsOnlyDialogue(input, "den Sprintnamen");
        MitarbeiterContainer mitarbeiter = speicher != null ? speicher
                : MitarbeiterContainer.getInstance();

        List<Sprint> onesprint = new ArrayList<>();
        for (Sprint iterable_element : sprints.getCurrentList()) {
            if (iterable_element.getVisibleNameESIN().equals(sName)) {
                onesprint.add(iterable_element);
            }
        }
        if (onesprint.isEmpty()) {
            ui.displayNothingFoundTable("Sprints");
        } else {
            new SprintView().dumpSorted(onesprint);
        }


        if (mitarbeiter.size() == 0) {
            ui.displayNothingFoundTable("Mitarbeiter");
        } else {
            new MitarbeiterView().dumpSorted(mitarbeiter.getCurrentListCopy());

        }

    }
}