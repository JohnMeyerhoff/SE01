package org.hbrs.se.ws21.midterm.model;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.

import java.util.ArrayList;
import java.util.List;
import org.hbrs.se.ws21.midterm.model.exception.ContainerException;
import org.hbrs.se.ws21.midterm.model.exception.PersistenceException;
import org.hbrs.se.ws21.midterm.model.exception.PersistenceException.ExceptionType;
import org.hbrs.se.ws21.midterm.model.persistence.PersistenceStrategy;

public class SprintContainer {

    /*
     * This is currently mostly a copy of the MitarbeiterContainer class
     * 
     */
    private List<Sprint> inhalt = new ArrayList<>();
    private PersistenceStrategy<Sprint> strategy = null;
    private static SprintContainer instance;

    private SprintContainer() {
        // default-Konstruktor überschrieben
        // Verwendung des singleton-Pattern

    }

    public void setStrategy(PersistenceStrategy<Sprint> strategy) {
        if (this.strategy != null) {
            try {
                this.strategy.closeConnection();
            } catch (PersistenceException e) {
                System.err.println("Could not close connection");
            }
        }
        this.strategy = strategy;
        try {
            strategy.openConnection();
        } catch (PersistenceException e) {
            System.err.println("Could not open connection");
        }
    }

    public static SprintContainer getInstance() {
        if (instance == null) {
            instance = new SprintContainer();
        }
        return instance;
    }

    public List<Sprint> getCurrentList() {
        return this.inhalt;
    }

    public List<Sprint> getCurrentListCopy() {
        /**
         * In the current implementation, this method returns a copy of the current
         * list.
         */
        List<Sprint> result = new ArrayList<>();
        for (Sprint member : this.inhalt) {
            result.add(member);
        }
        return result;
    }

    public void store() throws PersistenceException {
        if (strategy == null) {
            throw new PersistenceException(ExceptionType.NoStrategyIsSet,
                    "Es gibt keine Strategie zum abspeichern.");
        }

        strategy.openConnection();
        strategy.save(inhalt);
        strategy.closeConnection(); // alda hat nicht geschlossen
    }

    public void load() throws PersistenceException {
        if (strategy == null) {
            throw new PersistenceException(ExceptionType.NoStrategyIsSet,
                    "Es gibt keine Strategie zum abspeichern.");
        }

        strategy.openConnection();
        this.inhalt = strategy.load();
        strategy.closeConnection();
    }

    public void addMember(Sprint neu) throws ContainerException {
        boolean found = false;
        for (Sprint m : inhalt) {
            if (m.getID().equals(neu.getID())) {
                found = true;
            }
        }
        if (found) {
            throw new ContainerException("Das Member-Objekt mit der ID " + neu.getID()
                    + " ist bereits vorhanden!");
        } else {
            inhalt.add(neu);
        }
    }

    public String deleteMember(Integer id) {
        if (this.size() == 0) {
            return "nothing to delete";
        }
        for (Sprint m : inhalt) {
            if (m.getID().equals(id)) {
                inhalt.remove(m);
                return "deleted";
            }
        }
        return "unchanged";
        // Welche Nachteileergeben sich aus ihrer Sicht
        // für ein solchen Fehler-handling
        // gegenüber einer Lösung mit Exceptions?
        // Return codes sollten keine Strings sein.
        // Bool wäre als return code okay, hier sind es jetzt
        // drei Werte zwischen denen entschieden werden muss,
        // welche sich jederzeit ändern könnten
    }

    public int size() {
        return inhalt.size();
        // gegebene Methode von ArrayList
    }

    public static void developmentReset() {
        instance = null;
    }

    public void merge() {
        List<Sprint> strategyLoad = null;
        try {
            strategyLoad = strategy.load();
        } catch (PersistenceException e1) {
            e1.printStackTrace();
        }

        for (Sprint member : strategyLoad) {
            try {
                this.addMember(member);
            } catch (ContainerException e) {
                e.printStackTrace();
            }
        }
    }

    public void force() {
        try {
            this.load();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
}
