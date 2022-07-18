package org.hbrs.se.ws21.uebung1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hbrs.se.ws21.uebung1.controller.GermanTranslatorFactory;
import org.hbrs.se.ws21.uebung1.controller.Translator;
import org.junit.jupiter.api.Test;

public class GermanTranslatorTest {

  private static final String TRANSLATIONOF = "Übersetzung der Zahl ";
  private static final String NOTPOSSIBLE = " nicht möglich (";

  @Test
  public void zahlenNegativ() {
    // Äquivalenzklasse 1
    // <0
    // Soll eine Error-Ausgabe nach Spezifikation zurückgeben
    Translator zn = GermanTranslatorFactory.gtFactory();
    for (int i = -1000; i < 0; i++) {
      assertEquals(TRANSLATIONOF + i + NOTPOSSIBLE + Translator.version + ")",
          zn.translateNumber(i));
    }
  }

  @Test
  public void nullUebersetzen() {
    // Äquivalenzklasse 1
    // <0
    // Soll eine Error-Ausgabe nach Spezifikation zurückgeben
    Translator zn = GermanTranslatorFactory.gtFactory();
    assertEquals(TRANSLATIONOF + 0 + NOTPOSSIBLE + Translator.version + ")",
        zn.translateNumber(0));

  }

  @Test
  public void zahlenPositiv() {
    // Äquivalenzklasse 2
    // 0< zahl <=10
    // gültige eingaben
    Translator gt = GermanTranslatorFactory.gtFactory();
    assertEquals("fünf", gt.translateNumber(5));
    String[] deutsch = {"eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben",
        "acht", "neun", "zehn"};
    int i = 1;
    for (String d : deutsch) {
      assertEquals(d, gt.translateNumber(i++));
    }
  }

  @Test
  public void zahlenGross() {
    /**
     * <pre>
     * Äquivalenzklasse 3.
     * 10 < zahl .
     * ungültige eingaben, zahl zu gross.
     * </pre>
     */
    Translator gn = GermanTranslatorFactory.gtFactory();
    for (int i = 11; i < 1000; i++) {
      assertEquals(TRANSLATIONOF + i + NOTPOSSIBLE + Translator.version + ")",
          gn.translateNumber(i));
    }
  }
}
