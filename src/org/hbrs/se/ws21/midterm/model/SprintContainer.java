package org.hbrs.se.ws21.midterm.model;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 

//und John Meyerhoff bearbeitet worden.

public class SprintContainer extends Container<Sprint> {

    private static SprintContainer instance;

    private SprintContainer() {
        // default-Konstruktor überschrieben
        // Verwendung des singleton-Pattern

    }

    public static SprintContainer getInstance() {
        if (instance == null) {
            instance = new SprintContainer();
        }
        return instance;
    }

}
