package org.hbrs.se.ws21.command.model;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Expertise implements Serializable {

  HashMap<String, Integer> expertisen;
  HashMap<Integer, String> levelBezeichner;

  // integer (key) ist unser Level
  // String (value) ist unsere Bezeichnung (zb Java)

  // falls wir keine Angaben bekommen, gehen wir davorn aus
  // dass der Mitarbeiter einen leeren expertisensatz hat und nichts kann
  public Expertise() {
    expertisen = new HashMap<>();
    levelBezeichner = new HashMap<>();
    this.levelBezeichner.put(1, "Beginner");
    this.levelBezeichner.put(2, "Experte");
    this.levelBezeichner.put(3, "Top-Performer");
  }

  public void putFaehigkeitLvl(String faehigkeit, Integer l) {
    this.expertisen.put(faehigkeit, l);
  }

  public Map<String, Integer> getErfahrungen() {
    return this.expertisen;
  }

  public Map<Integer, String> getBezeichner() {
    return this.levelBezeichner;
  }

  public String getExpertiseLevel(Integer lvl) {
    // getOrDefault: erstes Argument der KEY wie bei get() und zweites Argument
    // der gleiche typ wie der RÜCKGABETYP von get() falls key nicht "aufschlüsselt"
    return levelBezeichner.getOrDefault(lvl, "Das Level" + lvl + "ist nicht vorhandeln.");
  }
}
