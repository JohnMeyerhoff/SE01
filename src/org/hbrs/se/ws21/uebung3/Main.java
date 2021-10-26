package org.hbrs.se.ws21.uebung3;

import org.hbrs.se.ws21.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws21.uebung3.persistence.PersistenceStrategyStream;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
public class Main {

    public static void main(String[] args) {
        Container maincontainer = new Main().buildEmptyContainer();
        try {
            maincontainer.load();
        } catch (PersistenceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Container buildInstances() {
        Container objekt = null;
        Member a = new ExampleMember();
        Member b = new ExampleMember();
        Member c = new ExampleMember();
        Member d = new ExampleMember();
        Member e = new ExampleMember();
        objekt = Container.getInstance();
        objekt.setStrategy(new PersistenceStrategyStream());
        try {

            objekt.addMember(a);
            objekt.addMember(b);
            objekt.addMember(c);
            objekt.addMember(d);
            objekt.addMember(e);
        } catch (Exception exx) {
            exx.printStackTrace();
        }
        return objekt;
    }

    public Container buildEmptyContainer() {
        Container objekt = null;

        objekt = Container.getInstance();
        objekt.setStrategy(new PersistenceStrategyStream());

        return objekt;
    }

}