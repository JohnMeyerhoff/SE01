package org.hbrs.se.ws21.uebung4;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
import java.util.List;

public class MemberView {

    public void dump(List<Member> liste) {
        for (Member x : liste) {
            System.out.println(x.toString());
            // alda:
            System.out.println("ID: " + x.getID());
        }
    }
    private class MemberComparator implements Comparator<Member>{
        public int compare(Member s1, Member s2) {
            return s1.getID().compareTo(s2.getID());           
            // s1 = 34 s2 = 2
            // 1,2,3,4
            }
    }

    public void dumpSorted(List<Member> liste){
        int i = 0;
        Collections.sort(liste, new MemberComparator());
        for (Member x : liste) {
            System.out.println(x.toString());
        }
    }
}
