package org.hbrs.se.ws21.uebung4.view;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
import java.util.List;

import org.hbrs.se.ws21.uebung4.model.Member;
import org.hbrs.se.ws21.uebung4.model.Mitarbeiter;

public class MemberView {

    public void dump(List<Member> liste) {
        for (Member x : liste) {
            System.out.println(x.toString());
            // alda:
            System.out.println("ID: " + x.getID());
        }
    }

    private class MemberComparator implements Comparator<Member> {
        public int compare(Member s1, Member s2) {
            return s1.getID().compareTo(s2.getID());
            // s1 = 34 s2 = 2
            // 1,2,3,4
        }
    }

    public void dumpSorted(List<? extends Mitarbeiter> liste) {
        Collections.sort(liste, new MemberComparator());
        String[][] tmp = listToStringarray(liste);
        TablePrinter printer = new TablePrinter(tmp.length,tmp[0].length);
        printer.setTable(tmp, 40);
        printer.print(System.out);

    }

    private String[][] listToStringarray(List<? extends Mitarbeiter> liste) {
        int i = 1;
        String[][] table = new String[liste.size()+1][5];
        table[0] = new String[] {
            "ID",
            "Vorname",
            "Nachname", 
            "Abteilung",
            "Rolle",
            };
        /**
         * EXPERTISEN WERDEN HIER ENTFERNT BZW NICHT BEACHTET.
         */
        for (Mitarbeiter ma : liste) {
            table[i] = new String[] {
                 "" + ma.getID(),
                 ma.getVorname(),
                 ma.getName(), 
                 ma.getAbteilung(),
                 ma.getRolle(),
                 };
            i++;
        }
        return table;

    }
}
