package org.hbrs.se.ws21.uebung4.model.persistence;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic

// und John Meyerhoff bearbeitet worden.

import java.util.List;
import org.hbrs.se.ws21.uebung4.model.Mitarbeiter;
import org.hbrs.se.ws21.uebung4.model.exception.PersistenceException;
import org.hbrs.se.ws21.uebung4.model.exception.PersistenceException.ExceptionType;

public class PersistenceStrategyMongoDB implements PersistenceStrategy<Mitarbeiter> {

  @Override
  public void openConnection() throws PersistenceException {
    throw new PersistenceException(ExceptionType.IMPLEMENTATIONNOTAVAILABLE, "Not implemented!");
  }

  @Override
  public void closeConnection() throws PersistenceException {
    throw new PersistenceException(ExceptionType.IMPLEMENTATIONNOTAVAILABLE, "Not implemented!");
  }

  @Override
  public void save(List<Mitarbeiter> member) throws PersistenceException {
    throw new PersistenceException(ExceptionType.IMPLEMENTATIONNOTAVAILABLE, "Not implemented!");
  }

  @Override
  public List<Mitarbeiter> load() throws PersistenceException {
    throw new PersistenceException(ExceptionType.IMPLEMENTATIONNOTAVAILABLE, "Not implemented!");
  }
}
