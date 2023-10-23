package org.hbrs.se.ws21.uebung3.persistence;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic

// und John Meyerhoff bearbeitet worden.

public class PersistenceException extends Exception {

  private final ExceptionType exceptionType;

  public PersistenceException(ExceptionType exceptionType, String message) {
    super(message);
    this.exceptionType = exceptionType;
  }

  public ExceptionType getExceptionTypeType() {
    return this.exceptionType;
  }

  /**
   * ExceptionTypes for declaring the type of an exception. Please feel free to extend this list!
   *
   * <p>Example: If an internal Exception of type java.lang.UnsupportedOperationException is thrown,
   * then this exception must be caught and transformed to an object of this exception-type,
   * consisting of Type 'IMPLEMENTATIONNOTAVAILABLE'. Re-throw the new exception e.g. to a client
   */
  public enum ExceptionType {
    IMPLEMENTATIONNOTAVAILABLE,
    CONNECTIONNOTAVAILABLE,
    NOSTRATEGYISSET
  }
}
