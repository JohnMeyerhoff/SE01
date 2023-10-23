package org.hbrs.se.ws21.composite.test;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hbrs.se.ws21.composite.ComplexDocument;
import org.hbrs.se.ws21.composite.Document;
import org.hbrs.se.ws21.composite.GraficDocument;
import org.hbrs.se.ws21.composite.TextDocument;
import org.junit.jupiter.api.Test;

public class TestClient {

  @Test
  public void empty() {
    ComplexDocument rootFolder = new ComplexDocument();
    assertEquals(0, rootFolder.getSizeInBytes());
  }

  @Test
  public void clientExample() {
    ComplexDocument doc0 = new ComplexDocument();
    doc0.setID(1);
    Document doc2 =
        new TextDocument("Die Klausur im Fach SE findet bald statt!", TextDocument.Encoding.UTF8);
    doc2.setID(2);
    ComplexDocument doc3 = new ComplexDocument();
    doc3.setID(3);
    Document doc4 = new GraficDocument("localhost:8080");
    doc4.setID(4);
    Document doc5 =
        new TextDocument(
            "Software Engineering I ist eine Vorlesung in den Studiengaengen BIS und BCS",
            TextDocument.Encoding.UTF32);
    doc5.setID(5);

    doc0.add(doc2);
    doc0.add(doc3);

    doc3.add(doc5);
    doc3.add(doc4);

    assertEquals(1541, doc0.getSizeInBytes());
    assertEquals(1200, doc4.getSizeInBytes());
    assertEquals(300, doc5.getSizeInBytes());
  }

  @Test
  public void clientSmallerExample() {

    ComplexDocument doc3 = new ComplexDocument();
    Document doc4 = new GraficDocument("localhost:8080");
    Document doc5 =
        new TextDocument(
            "Software Engineering I ist eine Vorlesung in den Studiengaengen BIS und BCS",
            TextDocument.Encoding.UTF32);

    // Es existiert kein Zwang zum direkten setzen der ID.
    doc3.setID(1);
    doc4.setID(2);
    doc5.setID(3);

    // Struktur:
    doc3.add(doc5);
    doc3.add(doc4);
    // Doc 4 und doc 5 sind jetzt im Complex doc in der liste
    assertEquals(1500, doc3.getSizeInBytes());
  }
}
