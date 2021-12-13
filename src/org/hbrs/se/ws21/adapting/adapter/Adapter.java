package org.hbrs.se.ws21.adapting.adapter;

import org.hbrs.se.ws21.adapting.hotelinfo.Formatvorgaben;
import org.hbrs.se.ws21.adapting.hotelinfo.Suchauftrag;
import org.hbrs.se.ws21.adapting.hotelinfo.Suchergebnis;
import org.hbrs.se.ws21.adapting.reiseanbieter.EchterReiseanbieter;
import org.hbrs.se.ws21.adapting.reiseanbieter.QueryObject;
import org.hbrs.se.ws21.adapting.reiseanbieter.QueryResult;
import org.hbrs.se.ws21.adapting.reiseanbieter.Reiseanbieter;

public class Adapter implements Formatvorgaben{
    private Reiseanbieter extern = new EchterReiseanbieter();

    @Override
    public Suchergebnis suche(Suchauftrag sa) {
        QueryObject o =concreteIN(sa); //speichtert die Daten des Auftrags in dem Format des Reisenabieters
        QueryResult e = extern.execute(o); //sendet5 eine für den Reiseanbieter gültige Abfrage
        return concreteOUT(e); //kovertierte Rückgabe in unserem Format 
    }

    private QueryObject concreteIN( Suchauftrag s1){
        // Inhalt dieser Methode für uns nicht wichtig
        return new QueryObject();
    }
   private Suchergebnis concreteOUT(QueryResult s2){
       // Inhalt dieser Methode für uns nicht wichtig
        return new Suchergebnis(5, " ");
   }
}
