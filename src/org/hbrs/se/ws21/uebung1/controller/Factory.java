package org.hbrs.se.ws21.uebung1.controller;

public class Factory {

  public Translator createTranslator() {
    return new GermanTranslator();
  }
}
