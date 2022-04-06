package org.hbrs.se.ws21.command.model.persistence;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 

//und Johannes Meyerhoff bearbeitet worden.

import java.util.List;

import org.hbrs.se.ws21.command.model.Mitarbeiter;
import org.hbrs.se.ws21.command.model.exception.PersistenceException;
import org.hbrs.se.ws21.command.model.exception.PersistenceException.ExceptionType;

public class PersistenceStrategyMongoDB implements PersistenceStrategy<Mitarbeiter> {
    private static final String NIMPL = "Not implemented!";

    @Override
    public void openConnection() throws PersistenceException {
        throw new PersistenceException(ExceptionType.IMPLEMENTATIONNOTAVAILABLE, NIMPL);
    }

    @Override
    public void closeConnection() throws PersistenceException {
        throw new PersistenceException(ExceptionType.IMPLEMENTATIONNOTAVAILABLE, NIMPL);
    }

    @Override
    public void save(List<Mitarbeiter> member) throws PersistenceException {
        throw new PersistenceException(ExceptionType.IMPLEMENTATIONNOTAVAILABLE, NIMPL);

    }

    @Override
    public List<Mitarbeiter> load() throws PersistenceException {
        throw new PersistenceException(ExceptionType.IMPLEMENTATIONNOTAVAILABLE, NIMPL);
    }
}
