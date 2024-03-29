package org.hbrs.se.ws21.midterm.model.persistence;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 

//und John Meyerhoff bearbeitet worden.

import java.util.List;
import org.hbrs.se.ws21.midterm.model.exception.PersistenceException;

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
public interface PersistenceStrategy<T extends org.hbrs.se.ws21.midterm.model.Member> {

  void openConnection() throws PersistenceException;

  List<T> load() throws PersistenceException;

  void save(List<T> member) throws PersistenceException;

  void closeConnection() throws PersistenceException;
}
