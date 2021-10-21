package org.hbrs.se.ws21.uebung3;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
public interface Member {
    // ID ist über einen Konstruktor einer abgeleiteten Klasse
    // explizit außerhalb der Container-Klasse zu belegen
    // --> Primärschlüssel zur Unterscheidung aller Member-Objekte
    Integer getID();

    @Override
    public String toString();
    /**
     * Wir können in Java nicht erzwingen, dass eine erbende Klasse die bereits
     * implementierte Methode toString() nochmal überschreibt. Im Interface können
     * wir mit default auch Methoden definieren, aber nicht toString()
     * überschreiben.
     */
}
