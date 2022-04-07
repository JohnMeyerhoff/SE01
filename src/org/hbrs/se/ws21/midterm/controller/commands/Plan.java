package org.hbrs.se.ws21.midterm.controller.commands;

import org.hbrs.se.ws21.midterm.controller.ExpertenHeuristik;
import org.hbrs.se.ws21.midterm.controller.Match;
import org.hbrs.se.ws21.midterm.model.Mitarbeiter;
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

    private Match sprintMatch;

    public Plan(PrintStream outstream, Scanner eingabe, MitarbeiterContainer speicher) {
        this(outstream, eingabe, speicher, new Match(new ExpertenHeuristik()));
    }

    public Plan(PrintStream outstream, Scanner eingabe, MitarbeiterContainer speicher,
            Match m) {
        super.outstream = outstream;
        super.input = eingabe;
        this.speicher = (speicher != null) ? speicher
                : MitarbeiterContainer.getInstance();
        this.sprintMatch = m;
    }

    @Override
    public void execute() {
        ConsoleUI ui = new ConsoleUI(outstream);
        SprintContainer sprints = SprintContainer.getInstance();

        MitarbeiterContainer mitarbeiter = speicher;
        String sName = ui.textAndDigitsOnlyDialogue(input, "den Sprintnamen");
        List<Sprint> onesprint = new ArrayList<>();
        for (Sprint iterable_element : sprints.getCurrentList()) {
            if (iterable_element.getVisibleNameESIN().equals(sName)) {
                onesprint.add(iterable_element);
            }
        }
        Sprint singleSprint = null;
        if (onesprint.isEmpty()) {
            ui.displayNothingFoundTable("Sprints ");
            outstream.println(
                    "Geben sie show ein, um sich die verfügbaren Sprints anzeigen zu lassen.");
        } else {
            new SprintView().dumpSorted(onesprint);
            singleSprint = onesprint.get(0);
            ui.vspace(2);
            if (mitarbeiter.size() == 0) {
                ui.displayNothingFoundTable("Mitarbeiter ");
            } else {
                
                if (singleSprint != null) {

                    Mitarbeiter[] ma = mitarbeiter.getCurrentListCopy()
                            .toArray(new Mitarbeiter[0]);
                    MitarbeiterView mv = new MitarbeiterView(outstream);
                    double[] matchness = this.sprintMatch
                            .sprintAndMitarbeiter(singleSprint, ma);
                    mv.dumpMatched(ma, matchness);
                }
            }
        }
    }
}
