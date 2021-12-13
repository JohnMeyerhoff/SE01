package org.hbrs.se.ws21.adapting.hotelinfo;

public class Suchauftrag {
    int preis;

    Suchauftrag() {
        this(-1);// wenn kein preis angegeben
    }

    public Suchauftrag(int preis) {
        this.preis = preis;
    }

    public int getPreis() {
        return this.preis;
    }
}
