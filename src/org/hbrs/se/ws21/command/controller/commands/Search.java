package org.hbrs.se.ws21.command.controller.commands;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import org.hbrs.se.ws21.command.model.Mitarbeiter;
import org.hbrs.se.ws21.command.model.MitarbeiterContainer;
import org.hbrs.se.ws21.command.view.ConsoleUI;
import org.hbrs.se.ws21.command.view.MemberView;

public class Search extends ContainerCommand {
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
        MemberView a = new MemberView(outstream);
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
        a.dumpSearched(x, fertigkeit);
    }

}
