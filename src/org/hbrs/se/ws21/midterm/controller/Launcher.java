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

/*
This class is used for launching the console application with the existing files "mitarbeiter.ser" and "sprint.ser" .
The console opens in its default state and accepts any text input.
After the console closes the application is closed as well.
*/

public class Launcher {

    @SuppressWarnings({ "java:S125", "java:S106" })
    public static void main(String[] args) {
        MitarbeiterContainer mitarbeiterContainer = MitarbeiterContainer.getInstance();
        // Singleton storage and management of Mitarbeiter instances
        PersistenceStrategyStream<Mitarbeiter> mitarbeiterStrategy = FilestreamFactory
                .<Mitarbeiter>createFileSaveStrategy("mitarbeiter");
        // The factory method produces a generic (Mitarbeiter) FilestreamStrategy
        mitarbeiterContainer.setStrategy(mitarbeiterStrategy);
        SprintContainer sc = SprintContainer.getInstance();
        PersistenceStrategyStream<Sprint> sprintStrategy = FilestreamFactory
                .<Sprint>createFileSaveStrategy("sprint");
        sc.setStrategy(sprintStrategy);
        // testMethod();
        Client cl = new Client(mitarbeiterContainer, new Scanner(System.in), System.out);
        // The client cl is using the default console input and output, this could be
        // changed to use files instead
        cl.konsole();

    }

    @SuppressWarnings({ "unused", "java:S106" })
    private static void testMethod() {
        PrintStream out = System.out;
        out.println();
        Sprint sp = new Sprint("28.02.1999", "28.04.1997", "SprintTest05");
        SprintContainer spc = SprintContainer.getInstance();

    }
}
