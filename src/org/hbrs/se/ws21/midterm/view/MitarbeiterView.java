package org.hbrs.se.ws21.midterm.view;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.hbrs.se.ws21.midterm.model.Expertise;
import org.hbrs.se.ws21.midterm.model.Member;
import org.hbrs.se.ws21.midterm.model.Mitarbeiter;

public class MitarbeiterView extends MemberView<Mitarbeiter> {

  private static final String VORNAME = "Vorname";
  private static final String NACHNAME = "Nachname";
  private static final String ABTEILUNG = "Abteilung";
  private static final String ROLLE = "Rolle";
  private static final String ID = "ID";

  @SuppressWarnings({"java:S106"})
  public MitarbeiterView() {
    this(System.out);
  }

  public MitarbeiterView(PrintStream out) {
    this.out = out;
  }

  @Override
  protected String[][] listToStringarray(List<? extends Mitarbeiter> liste) {
    int i = 1;
    String[][] table = new String[liste.size() + 1][5];
    table[0] = new String[]{ID, VORNAME, NACHNAME, ABTEILUNG, ROLLE,};
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

  @Override
  public void dumpSearched(List<Mitarbeiter> x, String fertigkeit) {
    Collections.sort(x, new MemberComparator());
    String[][] tmp = listToStringarrayWithExpertise(x, fertigkeit);
    TablePrinter printer = new TablePrinter(tmp.length, tmp[0].length);
    printer.setTable(tmp, 40);
    printer.print(out);

  }

  @Override
  protected String[][] listToStringarrayWithExpertise(List<? extends Mitarbeiter> liste,
      String fertigkeit) {
    int i = 1;
    String[][] table = new String[liste.size() + 1][6];
    table[0] = new String[]{ID, VORNAME, NACHNAME, ABTEILUNG, ROLLE,
        "Erfahrungsgrad",};
    /**
     * EXPERTISEN WERDEN HIER ENTFERNT BZW NICHT BEACHTET.
     */
    Map<Integer, String> labels = new Expertise().getBezeichner();
    for (Mitarbeiter ma : liste) {
      table[i] = new String[]{"" + ma.getID(), ma.getVorname(), ma.getName(),
          ma.getAbteilung(), ma.getRolle(),
          labels.getOrDefault(ma.getExpertise().getErfahrungen()
              .getOrDefault(fertigkeit, 0), "keine")};
      i++;
    }
    return table;

  }

  public void dumpMatched(Mitarbeiter[] liste, double[] match) {

    String[][] tmp = listToStringarrayWithMatch(liste, match);
    TablePrinter printer = new TablePrinter(tmp.length, tmp[0].length);
    printer.setTable(tmp, 40);
    printer.print(out);

  }

  public String[][] listToStringarrayWithMatch(Mitarbeiter[] liste, double[] match) {
    int i = 1;
    String[][] table = new String[liste.length + 1][6];
    table[0] = new String[]{ID, VORNAME, NACHNAME, ABTEILUNG, ROLLE,
        "Übereinstimmungsgrad",};
    /**
     * EXPERTISEN WERDEN HIER ENTFERNT BZW NICHT BEACHTET.
     */

    for (Mitarbeiter ma : liste) {
      table[i] = new String[]{"" + ma.getID(), ma.getVorname(), ma.getName(),
          ma.getAbteilung(), ma.getRolle(),
          " " + (int) Math.round(match[i - 1] * 100.0) + " %"};
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
      // s1 = 34 s2 = 2
      // 1,2,3,4
    }
  }
}
