package org.hbrs.se.ws21.uebung3.persistence;

import java.util.List;

import org.hbrs.se.ws21.uebung3.Member;
import org.hbrs.se.ws21.uebung3.persistence.PersistenceException.ExceptionType;

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
