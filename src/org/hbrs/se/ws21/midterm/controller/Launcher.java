package org.hbrs.se.ws21.midterm.controller;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

import java.util.Scanner;

import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.model.persistence.PersistenceStrategyStream;

public class Launcher { // main

    public static void main(String[] args) {
        MitarbeiterContainer maincontainer = MitarbeiterContainer.getInstance();
        maincontainer.setStrategy(new PersistenceStrategyStream<>());
        Client cl = new Client(maincontainer, new Scanner(System.in), System.out);
        cl.konsole();

    }
}
