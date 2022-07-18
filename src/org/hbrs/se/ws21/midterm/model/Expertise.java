package org.hbrs.se.ws21.midterm.model;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und John Meyerhoff bearbeitet worden.

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Expertise implements Serializable {

  HashMap<String, Integer> expertisen;
  HashMap<Integer, String> levelBezeichner;
  // integer (key) ist unser Level
  // String (value) ist unsere Bezeichnung (zb Java)

  // falls wir keine Angaben bekommen, gehen wir davorn aus
  // dass der Benutzer nix kann
  public Expertise() {
    expertisen = new HashMap<>();
    levelBezeichner = new HashMap<>();
    this.levelBezeichner.put(1, "Beginner");
    this.levelBezeichner.put(2, "Experte");
    this.levelBezeichner.put(3, "Top-Performer");

  }

  // Kunde gibt uns nur Level
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
    // getOrDefault: erste Komponente wie bei get() und zweite falls key nicht
    // exisitert
    return levelBezeichner.getOrDefault(lvl,
        "Das Level" + lvl + "ist nicht vorhandeln.");
  }

}
