package org.hbrs.se.ws21.uebung3;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hbrs.se.ws21.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws21.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se.ws21.uebung3.persistence.PersistenceStrategyStream;
import org.hbrs.se.ws21.uebung3.persistence.PersistenceException.ExceptionType;

public class Container {
    List<Member>                inhalt   = new ArrayList<>();
    PersistenceStrategy<Member> strategy = null;

    private static Container instance = null;

    private Container() {
        // default-Konstruktor überschrieben
        // Verwendung des singleton-Pattern
    }

    public void setStrategy(PersistenceStrategy<Member> strategy) {
        this.strategy = strategy;
    }

    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public void store() throws PersistenceException {
        if (strategy == null) {
            throw new PersistenceException(ExceptionType.NoStrategyIsSet,
                    "Es gibt keine Strategie zum abspeichern.");
        }
        strategy.save(inhalt);
    }

    public void load() throws PersistenceException {
        if (strategy == null) {
            throw new PersistenceException(ExceptionType.NoStrategyIsSet,
                    "Es gibt keine Strategie zum abspeichern.");
        }
       // List<Member> newContent = strategy.load();
        /*if(newContent.isEmpty()){
            throw new IllegalAccessError("Loster move....");
        }*/
        this.inhalt = strategy.load();
    }

    public void addMember(Member neu) throws ContainerException {
        boolean found = false;
        for (Member m : inhalt) {
            if (m.getID().equals(neu.getID())) {
                found = true;
            }
        }
        if (found) {
            throw new ContainerException(
                    "Das Member-Objekt mit der ID " + neu.getID() + " ist bereits vorhanden!");
        } else {
            inhalt.add(neu);
        }
    }

    public String deleteMember(Integer id) {
        if (this.size() == 0) {
            return "nothing to delete";
        }
        for (Member m : inhalt) {
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
}
