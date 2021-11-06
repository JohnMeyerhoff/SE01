package org.hbrs.se.ws21.uebung4;

import org.hbrs.se.ws21.uebung4.persistence.PersistenceException;
import org.hbrs.se.ws21.uebung4.persistence.PersistenceStrategyStream;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.
public class Main {

    public static void main(String[] args) {
        Container<Mitarbeiter> maincontainer = Container<Mitarbeiter>.getInstance();
        maincontainer.setStrategy(new PersistenceStrategyStream());
        Client cl = new Client();



        //tabellarische Form 

    }
}
