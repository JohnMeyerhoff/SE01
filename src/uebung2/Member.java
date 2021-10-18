package uebung2;

public interface Member {

    // ID ist über einen Konstruktor einer abgeleiteten Klasse
    // explizit außerhalb der Container-Klasse zu belegen
    // --> Primärschlüssel zur Unterscheidung aller Member-Objekte
    Integer getID();

    @Override
    public String toString();
/**
 * 
 * Wir können in java nicht fossieren, dass eine erbende Klasse 
 * die bereits implementierte Methode toString() nochmal 
 * überschreibt. Im Interface können wir mit default auch Methoden 
 * definieren aber nicht toString() überschreiben.
 */
}