package org.hbrs.se.ws21.uebung4.controller;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

import java.util.Scanner;

import org.hbrs.se.ws21.uebung4.model.MitarbeiterContainer;
import org.hbrs.se.ws21.uebung4.model.exception.PersistenceException;
import org.hbrs.se.ws21.uebung4.model.persistence.PersistenceStrategyStream;

public class Launcher { // main

    public static void main(String[] args) {
        MitarbeiterContainer maincontainer = MitarbeiterContainer.getInstance();
        maincontainer.setStrategy(new PersistenceStrategyStream<>());
        Client cl = new Client();
        try {
            cl.konsole(maincontainer, new Scanner(System.in), System.out);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
}
