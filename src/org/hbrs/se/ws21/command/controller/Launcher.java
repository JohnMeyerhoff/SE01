package org.hbrs.se.ws21.command.controller;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

import java.util.Scanner;

import org.hbrs.se.ws21.command.model.MitarbeiterContainer;
import org.hbrs.se.ws21.command.model.persistence.PersistenceStrategyStream;

public class Launcher { 

    public static void main(String[] args) {
        MitarbeiterContainer maincontainer = MitarbeiterContainer.getInstance();
        maincontainer.setStrategy(new PersistenceStrategyStream<>());
        Client cl = new Client(maincontainer, new Scanner(System.in), System.out);
        cl.konsole();

    }
}
