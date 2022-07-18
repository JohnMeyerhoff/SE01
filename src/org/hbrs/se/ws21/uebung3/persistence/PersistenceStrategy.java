package org.hbrs.se.ws21.uebung3.persistence;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 

//und Johannes Meyerhoff bearbeitet worden.

import java.util.List;

/**
 * Interface for defining basic methods for a persistence mechanism Each concrete algorithm (i.e.
 * strategy) must implement this method This interface corresponds to the abstract strategy w.r.t.
 * to the Strategy Design Pattern (GoF).
 * <p>
 * The following protocol applies: 1. openConnection 2. { load | save } (many times) 3.
 * closeConnection
 *
 * @param <E>
 */
public interface PersistenceStrategy<E> {

  void openConnection() throws PersistenceException;

  List<E> load() throws PersistenceException;

  void save(List<E> member) throws PersistenceException;

  void closeConnection() throws PersistenceException;
}
