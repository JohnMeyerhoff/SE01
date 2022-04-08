package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hbrs.se.ws21.midterm.model.Mitarbeiter;
import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.view.ConsoleUI;
import org.hbrs.se.ws21.midterm.view.MitarbeiterView;

public class Search extends ContainerCommand {
    @SuppressWarnings({ "java:S106" })
    public Search() {
        this(System.out, new Scanner(System.in), MitarbeiterContainer.getInstance());
    }

    public Search(PrintStream outstream, Scanner instream,
            MitarbeiterContainer mitarbeiterContainer) {
        this.outstream = outstream;
        this.input = instream;
        this.speicher = mitarbeiterContainer;
    }

    @Override
    public void execute() {
        // TODO: Streams beheben in commands
        MitarbeiterView a = new MitarbeiterView(outstream);
        ConsoleUI ui = new ConsoleUI(outstream);
        String fertigkeit = ui.searchDialogue(input);
        List<Mitarbeiter> x = speicher.getCurrentListCopy().stream()
                .filter(ma -> ma.getExpertise().getErfahrungen().containsKey(fertigkeit))
                .toList();
        if (x.isEmpty()) {
            ui.displayExpertiseNotFound();
        } else {
            ui.displayExpertiseFound(fertigkeit);
        }
        a.dumpSearched(new ArrayList<>(x), fertigkeit); //New Arraylist because List would not be modifiable.
    }

}
