package org.hbrs.se.ws21.uebung4;
import java.util.HashMap;

public class Expertise {
    HashMap<String, Integer> expertisen;
    HashMap<Integer, String> levelBezeichner;
    // integer (key) ist unser Level
    // String (value) ist unsere Bezeichnung (zb Java)

    //falls wir keine Angaben bekommen, gehen wir davorn aus
    //dass der Benutzer nix kann
    public Expertise(){
        this(0);
    }

    public Expertise(String lvlAngabe){
        expertisen = new HashMap<>();
        levelBezeichner = new HashMap<>();

        if (lvlAngabe.equals("Beginner")) {
            this.expertisen.put("Beginner", 1);
        }
        if (lvlAngabe.equals("Experte")) {
            this.expertisen.put("Experte", 2);

        }
        if (lvlAngabe.equals("Top-Performer")) {
            this.expertisen.put("Top-Performer", 3);

        }
    }

    public Expertise(Integer l) {
        expertisen = new HashMap<>();
        levelBezeichner = new HashMap<>();

        expertisen = new HashMap<>();
        if (l.equals("1")) {
            this.expertisen.put("Beginner", 1);
        }
        if (l.equals("2")) {
            this.expertisen.put("Experte", 2);

        }
        if (l.equals("3")) {
            this.expertisen.put("Top-Performer", 3);

        }
        //this.levelBezeichner.put(1, "Beginner");

    }
    //Kunde gibt uns nur Level
    protected boolean setBezeichnungLvl(String faehigkeit, Integer l){
        
        this.expertisen.put(l, bez); //Setzten bei HashMap

        return true;
    }
    // was ist das Level für Java?
    public Integer getExpertiseLevel(String bezeichnung) {
        for (int i = 1; i <= 3; i++) {
            if (bezeichnung.equals(expertisen.get(i))) {
                // get() gibt hier String zurück!!
                return i;
            }
        }
        return -1;
    }

    public String getExpertiseLevel(Integer lvl) {
        // getOrDefault: erste Komponente wie bei get() und zweite falls key nicht
        // exisitert
        return expertisen.getOrDefault(lvl, "Das Level" + lvl + "ist vorhandeln.");
    }

}
