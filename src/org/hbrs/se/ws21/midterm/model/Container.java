package org.hbrs.se.ws21.midterm.model;

import org.hbrs.se.ws21.midterm.model.exception.ContainerException;
import org.hbrs.se.ws21.midterm.model.exception.PersistenceException;
import org.hbrs.se.ws21.midterm.model.persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class Container<T extends Member> {
    List<T> inhalt = new ArrayList<>();

    protected PersistenceStrategy<T> strategy = null;

    public void setStrategy(PersistenceStrategy<T> strategy) {
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

    public List<T> getCurrentList() {
        return this.inhalt;
    }

    public List<T> getCurrentListCopy() {
        /**
         * In the current implementation, this method returns a copy of the current
         * list.
         */
        List<T> result = new ArrayList<>();
        for (T member : this.inhalt) {
            result.add(member);
        }
        return result;
    }

    public void store() throws PersistenceException {
        if (strategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NOSTRATEGYISSET,
                    "Es gibt keine Strategie zum abspeichern.");
        }

        strategy.openConnection();
        strategy.save(inhalt);
        strategy.closeConnection(); // alda hat nicht geschlossen
    }

    public void load() throws PersistenceException {
        if (strategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NOSTRATEGYISSET,
                    "Es gibt keine Strategie zum abspeichern.");
        }

        strategy.openConnection();
        this.inhalt = strategy.load();
        strategy.closeConnection();
    }

    public void addMember(T neu) throws ContainerException {
        boolean found = false;
        for (T m : inhalt) {
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
        for (T m : inhalt) {
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

    public void merge() {
        List<T> strategyLoad = null;
        try {
            strategyLoad = strategy.load();
        } catch (PersistenceException e1) {
            e1.printStackTrace();
        }

        for (T member : strategyLoad) {
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
