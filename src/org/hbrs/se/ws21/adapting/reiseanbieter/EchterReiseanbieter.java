package org.hbrs.se.ws21.adapting.reiseanbieter;

public class EchterReiseanbieter implements Reiseanbieter {

    @Override
    public QueryResult execute(QueryObject o) {
        // Inhalt ist nicht relevant
        return new QueryResult();
    }
    
}
