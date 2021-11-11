package org.hbrs.se.ws21.command.model.persistence;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.

import java.util.List;

import org.hbrs.se.ws21.command.model.Member;
import org.hbrs.se.ws21.command.model.exception.PersistenceException;

/**
 * Interface for defining basic methods for a persistence mechanism Each
 * concrete algorithm (i.e. strategy) must implement this method This interface
 * corresponds to the abstract strategy w.r.t. to the Strategy Design Pattern
 * (GoF).
 *
 * The following protocol applies: 1. openConnection 2. { load | save } (many
 * times) 3. closeConnection
 *
 * @param <E>
 */
public interface PersistenceStrategy<T extends Member> {
    public void openConnection() throws PersistenceException;

    public List<T> load() throws PersistenceException;

    public void save(List<T> member) throws PersistenceException;

    public void closeConnection() throws PersistenceException;
}
