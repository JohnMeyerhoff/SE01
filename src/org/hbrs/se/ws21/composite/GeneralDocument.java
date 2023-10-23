package org.hbrs.se.ws21.composite;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.
public abstract class GeneralDocument implements Document {

  private int id;

  @Override
  public boolean setID(int id) {
    this.id = id;
    return true;
    // TODO: Check for collisions?
  }

  @Override
  public int getID() {
    return id;
  }
}
