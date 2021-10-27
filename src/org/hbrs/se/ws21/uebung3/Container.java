package org.hbrs.se.ws21.uebung3;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
import java.util.ArrayList;
import java.util.List;

import org.hbrs.se.ws21.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws21.uebung3.persistence.PersistenceException.ExceptionType;
import org.hbrs.se.ws21.uebung3.persistence.PersistenceStrategy;

public class Container {
    private List<Member> inhalt = new ArrayList<>();
    private PersistenceStrategy<Member> strategy = null;
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

    private static final Object lock = new Object(); // Schlüssel für kritischen Block

    public static Container getInstanceAlda() {
        // Vorteil: Instanzuerung des Bedarf(!). Lazy
        // Nachteil: Thread-safe? Nein (ohne synchronized)
        //Thread-Safe: eine Komponente gleichzeitig von verschiedenen Programmbereichen
        // mehrfach ausgeführt werden kann, ohne dass diese sich gegenseitig behindern.
        synchronized (lock) { // kritischer Code
            if (instance == null) {
                instance = new Container();
            }
        }
        // unkritischer Code
        return instance;
    }

    public List<Member> getCurrentList() {
        return this.inhalt;
    }

    public List<Member> getCurrentListCopy() {
        /**
         * In the current implementation, this method returns a copy of the current
         * list.
         */
        List<Member> result = new ArrayList<>();
        for (Member member : this.inhalt) {
            result.add(member);
        }
        return result;
    }

    public void store() throws PersistenceException {
        if (strategy == null) {
            throw new PersistenceException(ExceptionType.NoStrategyIsSet, "Es gibt keine Strategie zum abspeichern.");
        }

        strategy.openConnection();
        strategy.save(inhalt);
        strategy.closeConnection();
    }

    public void load() throws PersistenceException {
        if (strategy == null) {
            throw new PersistenceException(ExceptionType.NoStrategyIsSet, "Es gibt keine Strategie zum abspeichern.");
        }

        strategy.openConnection();
        this.inhalt = strategy.load();
        strategy.closeConnection();
    }

    public void addMember(Member neu) throws ContainerException {
        boolean found = false;
        for (Member m : inhalt) {
            if (m.getID().equals(neu.getID())) {
                found = true;
            }
        }
        if (found) {
            throw new ContainerException("Das Member-Objekt mit der ID " + neu.getID() + " ist bereits vorhanden!");
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
