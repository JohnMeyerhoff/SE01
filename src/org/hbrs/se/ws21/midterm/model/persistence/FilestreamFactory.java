package org.hbrs.se.ws21.midterm.model.persistence;

import org.hbrs.se.ws21.midterm.model.Member;

public class FilestreamFactory<T extends Member> {
    
    public PersistenceStrategyStream<T> createFileSaveStrategy(String filename) {
        PersistenceStrategyStream<T> spStrat = new PersistenceStrategyStream<>();
        spStrat.setLocation(filename+".ser");
        return spStrat;

    }
}
