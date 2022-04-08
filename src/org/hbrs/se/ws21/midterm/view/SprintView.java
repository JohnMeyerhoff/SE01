package org.hbrs.se.ws21.midterm.view;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hbrs.se.ws21.midterm.model.Member;
import org.hbrs.se.ws21.midterm.model.Sprint;

public class SprintView extends MemberView<Sprint> {

    @SuppressWarnings({ "java:S106" })
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

    @Override
    public void dumpSorted(List<? extends Sprint> liste) {
        Collections.sort(liste, new SprintComparator());
        String[][] tmp = listToStringarray(liste);
        TablePrinter printer = new TablePrinter(tmp.length, tmp[0].length);
        printer.setTable(tmp, 40);
        printer.print(out);
    }

    @Override
    protected String[][] listToStringarray(List<? extends Sprint> liste) {
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

}
