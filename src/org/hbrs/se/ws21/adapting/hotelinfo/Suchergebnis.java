package org.hbrs.se.ws21.adapting.hotelinfo;

public class Suchergebnis {

  int preis;
  String hotelname;

  Suchergebnis() {
    this(-1, "Namenlos");// wenn kein preis angegeben
  }

  public Suchergebnis(int preis, String name) {
    this.preis = preis;
    this.hotelname = name;
  }

  public int getPreis() {
    return this.preis;
  }

  public String getName() {
    return this.hotelname;
  }

  @Override
  public String toString() {
    return "Hotel " + hotelname + ", Preis: " + preis + " Euro je nacht";
  }

}
