package org.hbrs.se.ws21.midterm.controller;

import java.io.PrintStream;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

import java.util.Scanner;

import org.hbrs.se.ws21.midterm.model.Mitarbeiter;
import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.model.Sprint;
import org.hbrs.se.ws21.midterm.model.SprintContainer;
import org.hbrs.se.ws21.midterm.model.persistence.FilestreamFactory;
import org.hbrs.se.ws21.midterm.model.persistence.PersistenceStrategyStream;

public class Launcher {

    @SuppressWarnings({ "java:S125", "java:S106" })
    public static void main(String[] args) {
        MitarbeiterContainer maincontainer = MitarbeiterContainer.getInstance();
        PersistenceStrategyStream<Mitarbeiter> mStrat = new FilestreamFactory<Mitarbeiter>().createFileSaveStrategy("mitarbeiter");
        maincontainer.setStrategy(mStrat);
        SprintContainer sc = SprintContainer.getInstance();
        PersistenceStrategyStream<Sprint> spStrat = new FilestreamFactory<Sprint>().createFileSaveStrategy("sprint");
        sc.setStrategy(spStrat);
        // testMethod();
        Client cl = new Client(maincontainer, new Scanner(System.in), System.out);
        cl.konsole();

    }

    @SuppressWarnings({ "unused", "java:S106" })
    private static void testMethod() {
        PrintStream out = System.out;
        out.println();

        Sprint sp = new Sprint("28.02.1999", "28.04.1997");
        SprintContainer spc = SprintContainer.getInstance();

    }
}
