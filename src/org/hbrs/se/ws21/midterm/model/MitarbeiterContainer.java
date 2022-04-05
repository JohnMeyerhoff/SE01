package org.hbrs.se.ws21.midterm.model;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.

import java.util.ArrayList;
import java.util.List;
import org.hbrs.se.ws21.midterm.model.exception.ContainerException;
import org.hbrs.se.ws21.midterm.model.exception.PersistenceException;
import org.hbrs.se.ws21.midterm.model.exception.PersistenceException.ExceptionType;
import org.hbrs.se.ws21.midterm.model.persistence.PersistenceStrategy;

public class MitarbeiterContainer extends Container<Mitarbeiter> {
    private static MitarbeiterContainer instance;

    public static MitarbeiterContainer getInstance() {
        if (instance == null) {
            instance = new MitarbeiterContainer();
        }
        return instance;
    }
    private MitarbeiterContainer() {
        // default-Konstruktor überschrieben
        // Verwendung des singleton-Pattern
    }

    public static void developmentReset() {
        instance = null;
    }

}
