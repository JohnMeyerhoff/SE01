package org.hbrs.se.ws21.uebung4.controller;

import org.hbrs.se.ws21.uebung4.model.Mitarbeiter;
import org.hbrs.se.ws21.uebung4.model.MitarbeiterContainer;
import org.hbrs.se.ws21.uebung4.model.exception.PersistenceException;
import org.hbrs.se.ws21.uebung4.model.persistence.PersistenceStrategyStream;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.
public class Main {

    public static void main(String[] args) {
        MitarbeiterContainer maincontainer = MitarbeiterContainer.getInstance();
        maincontainer.setStrategy(new PersistenceStrategyStream<>());
        Client cl = new Client();
        try {
            cl.konsole(maincontainer);
        } catch (PersistenceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        //tabellarische Form 

    }
}
