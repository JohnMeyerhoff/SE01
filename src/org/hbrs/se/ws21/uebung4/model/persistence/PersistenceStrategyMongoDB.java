package org.hbrs.se.ws21.uebung4.model.persistence;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.

import java.util.List;

import org.hbrs.se.ws21.uebung4.model.Member;
import org.hbrs.se.ws21.uebung4.model.exception.PersistenceException;
import org.hbrs.se.ws21.uebung4.model.exception.PersistenceException.ExceptionType;

public class PersistenceStrategyMongoDB implements PersistenceStrategy<Member> {

    @Override
    public void openConnection() throws PersistenceException {
        throw new PersistenceException(ExceptionType.ImplementationNotAvailable, "Not implemented!");
    }

    @Override
    public void closeConnection() throws PersistenceException {
        throw new PersistenceException(ExceptionType.ImplementationNotAvailable, "Not implemented!");
    }

    @Override
    public void save(List<Member> member) throws PersistenceException {
        throw new PersistenceException(ExceptionType.ImplementationNotAvailable, "Not implemented!");

    }

    @Override
    public List<Member> load() throws PersistenceException {
        throw  new PersistenceException(ExceptionType.ImplementationNotAvailable, "Not implemented!");
    }
}
