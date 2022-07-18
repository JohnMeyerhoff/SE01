package org.hbrs.se.ws21.command.model;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.

import java.util.ArrayList;
import java.util.List;
import org.hbrs.se.ws21.command.model.exception.ContainerException;
import org.hbrs.se.ws21.command.model.exception.PersistenceException;
import org.hbrs.se.ws21.command.model.exception.PersistenceException.ExceptionType;
import org.hbrs.se.ws21.command.model.persistence.PersistenceStrategy;

public class MitarbeiterContainer {

  private static MitarbeiterContainer instance;
  private List<Mitarbeiter> inhalt = new ArrayList<>();
  private PersistenceStrategy<Mitarbeiter> strategy = null;

  private MitarbeiterContainer() {
    // default-Konstruktor überschrieben
    // Verwendung des singleton-Pattern

    // alda: falsche Lösung wäre eine if-Abfage (created == false) im Konstruktor,
    // da dort immer ein Objekt erzeugt wird.
    // man kann Erstellung abbrechen, jedoch wurde das Obejekt im
    // Konstruktor erzeugt
  }

  public static MitarbeiterContainer getInstance() {
    if (instance == null) {
      instance = new MitarbeiterContainer();
    }
    return instance;
  }

  public static void developmentReset() {
    instance = null;
  }

  public void setStrategy(PersistenceStrategy<Mitarbeiter> strategy) {
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

  public List<Mitarbeiter> getCurrentList() {
    return this.inhalt;
  }

  public List<Mitarbeiter> getCurrentListCopy() {
    /**
     * In the current implementation, this method returns a copy of the current
     * list.
     */
    List<Mitarbeiter> result = new ArrayList<>();
    for (Mitarbeiter member : this.inhalt) {
      result.add(member);
    }
    return result;
  }

  public void store() throws PersistenceException {
    if (strategy == null) {
      throw new PersistenceException(ExceptionType.NOSTRATEGYISSET,
          "Es gibt keine Strategie zum abspeichern.");
    }

    strategy.openConnection();
    strategy.save(inhalt);
    strategy.closeConnection();
  }

  public void load() throws PersistenceException {
    if (strategy == null) {
      throw new PersistenceException(ExceptionType.NOSTRATEGYISSET,
          "Es gibt keine Strategie zum abspeichern.");
    }

    strategy.openConnection();
    this.inhalt = strategy.load();
    strategy.closeConnection();
  }

  public void addMember(Mitarbeiter neu) throws ContainerException {
    boolean found = false;
    for (Mitarbeiter m : inhalt) {
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
    for (Mitarbeiter m : inhalt) {
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
    List<Mitarbeiter> strategyLoad = null;
    try {
      strategyLoad = strategy.load();
    } catch (PersistenceException e1) {
      e1.printStackTrace();
    }

    for (Mitarbeiter member : strategyLoad) {
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
