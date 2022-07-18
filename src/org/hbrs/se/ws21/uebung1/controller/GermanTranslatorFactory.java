package org.hbrs.se.ws21.uebung1.controller;

public class GermanTranslatorFactory {

  GermanTranslatorFactory() {
    // Empty
  }

  public static GermanTranslator gtFactory() {
    return new GermanTranslator();
  }

}
