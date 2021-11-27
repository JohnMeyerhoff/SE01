package org.hbrs.se.ws21.uebung3;

import org.hbrs.se.ws21.uebung3.persistence.PersistenceStrategyStream;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.
public class Main {

    public static void main(String[] args) {
        Container maincontainer = Container.getInstance();
        maincontainer.setStrategy(new PersistenceStrategyStream());
        Client cl = new Client();
        cl.displayContainerWithMemberview(Container.getInstance(), new MemberView());
    }
}
