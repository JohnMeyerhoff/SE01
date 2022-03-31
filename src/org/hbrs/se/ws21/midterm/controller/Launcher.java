package org.hbrs.se.ws21.midterm.controller;

import java.io.PrintStream;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

import java.util.Scanner;

import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.model.Sprint;
import org.hbrs.se.ws21.midterm.model.SprintContainer;
import org.hbrs.se.ws21.midterm.model.persistence.PersistenceStrategyStream;

public class Launcher { // main

    @SuppressWarnings({ "java:S125" })
    public static void main(String[] args) {
        MitarbeiterContainer maincontainer = MitarbeiterContainer.getInstance();
        maincontainer.setStrategy(new PersistenceStrategyStream<>());
        SprintContainer sc = SprintContainer.getInstance();
        sc.setStrategy(new PersistenceStrategyStream<>());
        //testMethod();
        Client cl = new Client(maincontainer, new Scanner(System.in), System.out);
        cl.konsole();

    }

    @SuppressWarnings({"unused","java:S106"})
    private static void testMethod() {
        PrintStream out = System.out;
        out.println();
          
        Sprint sp = new Sprint("28.02.1999","28.04.1997");
        SprintContainer spc = SprintContainer.getInstance();

    }
}
