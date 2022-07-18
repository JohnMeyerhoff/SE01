package org.hbrs.se.ws21.command.view;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.hbrs.se.ws21.command.model.Expertise;
import org.hbrs.se.ws21.command.model.Member;
import org.hbrs.se.ws21.command.model.Mitarbeiter;

public class MemberView {

  private final PrintStream out;

  public MemberView() {
    this(System.out);
  }

  public MemberView(PrintStream out) {
    this.out = out;
  }

  public void dumpSorted(List<? extends Mitarbeiter> liste) {
    Collections.sort(liste, new MemberComparator());
    String[][] tmp = listToStringarray(liste);
    TablePrinter printer = new TablePrinter(tmp.length, tmp[0].length);
    printer.setTable(tmp, 40);
    printer.print(out);

  }

  private String[][] listToStringarray(List<? extends Mitarbeiter> liste) {
    int i = 1;
    String[][] table = new String[liste.size() + 1][5];
    table[0] = new String[]{"ID", "Vorname", "Nachname", "Abteilung", "Rolle",};
    /**
     * EXPERTISEN WERDEN HIER ENTFERNT BZW NICHT BEACHTET.
     */
    for (Mitarbeiter ma : liste) {
      table[i] = new String[]{"" + ma.getID(), ma.getVorname(), ma.getName(),
          ma.getAbteilung(), ma.getRolle(),};
      i++;
    }
    return table;

  }

  public void dumpSearched(List<Mitarbeiter> x, String fertigkeit) {
    Collections.sort(x, new MemberComparator());
    String[][] tmp = listToStringarrayWithExpertise(x, fertigkeit);
    TablePrinter printer = new TablePrinter(tmp.length, tmp[0].length);
    printer.setTable(tmp, 40);
    printer.print(out);

  }

  private String[][] listToStringarrayWithExpertise(List<? extends Mitarbeiter> liste,
      String fertigkeit) {
    int i = 1;
    String[][] table = new String[liste.size() + 1][6];
    table[0] = new String[]{"ID", "Vorname", "Nachname", "Abteilung", "Rolle",
        "Erfahrungsgrad",};
    /**
     * EXPERTISEN WERDEN HIER ENTFERNT BZW NICHT BEACHTET.
     */
    HashMap<Integer, String> labels = new Expertise().getBezeichner();
    for (Mitarbeiter ma : liste) {
      table[i] = new String[]{"" + ma.getID(), ma.getVorname(), ma.getName(),
          ma.getAbteilung(), ma.getRolle(),
          labels.getOrDefault(ma.getExpertise().getErfahrungen()
              .getOrDefault(fertigkeit, 0), "keine")};
      i++;
    }
    return table;

  }

  public void dumpAbteilung(List<Mitarbeiter> x, String abteilungsfilter) {
    Collections.sort(x, new MemberComparator());
    List<Mitarbeiter> y = x.stream()
        .filter(ma -> ma.getAbteilung().equalsIgnoreCase(abteilungsfilter))
        .toList();
    String[][] tmp = listToStringarray(y);
    TablePrinter printer = new TablePrinter(tmp.length, tmp[0].length);
    printer.setTable(tmp, 40);
    printer.print(out);

  }

  private class MemberComparator implements Comparator<Member> {

    public int compare(Member s1, Member s2) {
      return s1.getID().compareTo(s2.getID());
    }
  }
}
