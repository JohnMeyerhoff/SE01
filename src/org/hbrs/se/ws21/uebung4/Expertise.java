package org.hbrs.se.ws21.uebung4;
import java.util.HashMap;

public class Expertise {
    HashMap<Integer, String> expertise;
    // integer (key) ist unser Level
    // String (value) ist unsere Bezeichnung (zb Java)

    public Expertise() {
        expertise = new HashMap<>();
    }
    public boolean setBezeichnungLvl(String bez, Integer l){
        if(l < 0 || l > 3){
           return false;
        }
        if(!(expertise.size() <= 3 )){
            return false;
        }
        this.expertise.put(l, bez); //Setzten bei HashMap

        return true;
    }
    // was ist das Level für Java?
    public Integer getExpertiseLevel(String bezeichnung) {
        for (int i = 1; i <= 3; i++) {
            if (bezeichnung.equals(expertise.get(i))) {
                // get() gibt hier String zurück!!
                return i;
            }
        }
        return -1;
    }

    public String getExpertiseLevel(Integer lvl) {
        // getOrDefault: erste Komponente wie bei get() und zweite falls key nicht
        // exisitert
        return expertise.getOrDefault(lvl, "Das Level" + lvl + "ist vorhandeln.");
    }

}
