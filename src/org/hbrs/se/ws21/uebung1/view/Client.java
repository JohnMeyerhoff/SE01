package org.hbrs.se.ws21.uebung1.view;

import org.hbrs.se.ws21.uebung1.controller.GermanTranslatorFactory;
import org.hbrs.se.ws21.uebung1.controller.Translator;

public class Client {

  /*
   * Methode zur Ausgabe einer Zahl auf der Console
   */
  public void display(int nummer) {
    Translator generalTranslator = GermanTranslatorFactory.gtFactory();
    System.out.println("Ergebnis: " + generalTranslator.translateNumber(nummer));
  }
}
