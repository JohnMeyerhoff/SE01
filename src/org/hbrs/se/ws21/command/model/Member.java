package org.hbrs.se.ws21.command.model;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

import java.io.Serializable;

public interface Member extends Serializable {

  // ID ist über einen Konstruktor einer abgeleiteten Klasse
  // explizit außerhalb der Container-Klasse zu belegen
  // --> Primärschlüssel zur Unterscheidung aller Member-Objekte
  Integer getID();

  @Override
  String toString();
  /**
   * Wir können in Java nicht erzwingen, dass eine erbende Klasse die bereits implementierte Methode
   * toString() nochmal überschreibt. Im Interface können wir mit default auch Methoden definieren,
   * aber nicht toString() überschreiben.
   */
}
