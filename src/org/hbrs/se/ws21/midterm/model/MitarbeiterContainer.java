package org.hbrs.se.ws21.midterm.model;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und John Meyerhoff bearbeitet worden.

public class MitarbeiterContainer extends Container<Mitarbeiter> {

  private static MitarbeiterContainer instance;

  private MitarbeiterContainer() {
    // default-Konstruktor überschrieben
    // Verwendung des singleton-Pattern
  }

  public static MitarbeiterContainer getInstance() {
    if (instance == null) {
      instance = new MitarbeiterContainer();
    }
    return instance;
  }

  public static void developmentReset() {
    instance = null;
  }

}
