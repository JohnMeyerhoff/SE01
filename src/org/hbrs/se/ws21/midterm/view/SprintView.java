package org.hbrs.se.ws21.midterm.view;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.hbrs.se.ws21.midterm.model.Expertise;
import org.hbrs.se.ws21.midterm.model.Member;
import org.hbrs.se.ws21.midterm.model.Mitarbeiter;
import org.hbrs.se.ws21.midterm.model.Sprint;

public class SprintView {

    private PrintStream out;

    public SprintView() {
        this(System.out);
    }

    public SprintView(PrintStream out) {
        this.out = out;
    }

    private class SprintComparator implements Comparator<Member> {
        public int compare(Member s1, Member s2) {
            return s1.getID().compareTo(s2.getID());
            // s1 = 34 s2 = 2
            // 1,2,3,4
        }
    }

    public void dumpSorted(List<? extends Sprint> liste) {
        Collections.sort(liste, new SprintComparator());
        String[][] tmp = listToStringarray(liste);
        TablePrinter printer = new TablePrinter(tmp.length, tmp[0].length);
        printer.setTable(tmp, 40);
        printer.print(out);

    }

    private String[][] listToStringarray(List<? extends Sprint> liste) {
        int i = 1;
        String[][] table = new String[liste.size() + 1][5];
        table[0] = new String[] { "ID", "Name", "Start", "Ende" };
        /**
         * EXPERTISEN WERDEN HIER ENTFERNT BZW NICHT BEACHTET.
         */
        for (Sprint ma : liste) {
            table[i] = new String[] { "" + ma.getID(), ma.getVisibleNameESIN(),
                    "" + ma.getStart().tag() + "." + ma.getStart().monat() + "."
                            + ma.getStart().jahr(),

                    "" + ma.getStart().tag() + "." + ma.getStart().monat() + "."
                            + ma.getStart().jahr() };
            i++;
        }
        return table;

    }

    public void dumpSearched(List<Mitarbeiter> x, String fertigkeit) {
        Collections.sort(x, new SprintComparator());
        String[][] tmp = listToStringarrayWithExpertise(x, fertigkeit);
        TablePrinter printer = new TablePrinter(tmp.length, tmp[0].length);
        printer.setTable(tmp, 40);
        printer.print(out);

    }

    private String[][] listToStringarrayWithExpertise(List<? extends Mitarbeiter> liste,
            String fertigkeit) {
        int i = 1;
        String[][] table = new String[liste.size() + 1][6];
        table[0] = new String[] { "ID", "Vorname", "Nachname", "Abteilung", "Rolle",
                "Erfahrungsgrad", };
        /**
         * EXPERTISEN WERDEN HIER ENTFERNT BZW NICHT BEACHTET.
         */
        HashMap<Integer, String> labels = new Expertise().getBezeichner();
        for (Mitarbeiter ma : liste) {
            table[i] = new String[] { "" + ma.getID(), ma.getVorname(), ma.getName(),
                    ma.getAbteilung(), ma.getRolle(),
                    labels.getOrDefault(ma.getExpertise().getErfahrungen()
                            .getOrDefault(fertigkeit, 0), "keine") };
            i++;
        }
        return table;

    }

}
