package org.hbrs.se.ws21.uebung4.model.exception;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 

//und Johannes Meyerhoff bearbeitet worden.

public class PersistenceException extends Exception {

    private ExceptionType exceptionType;

    public ExceptionType getExceptionTypeType() {
        return this.exceptionType;
    }

    public PersistenceException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }

    /**
     * ExceptionTypes for declaring the type of an exception. Please feel free to
     * extend this list!
     *
     * Example: If an internal Exception of type
     * java.lang.UnsupportedOperationException is thrown, then this exception must
     * be caught and transformed to an object of this exception-type, consisting of
     * Type 'IMPLEMENTATIONNOTAVAILABLE'. Re-throw the new exception e.g. to a
     * client
     */
    public enum ExceptionType {
        IMPLEMENTATIONNOTAVAILABLE, CONNECTIONNOTAVAILABLE, NOSTRATEGYISSET
    }
}
