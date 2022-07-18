package org.hbrs.se.ws21.midterm.model.persistence;

public class Loading {

  private static final String WQ = "store exit\n"; // Write and Quit
  private final String vorname;
  private final String nachname;
  private final String rolle;
  private final String abteilung;
  private final String expertiseI;
  private final int expertiseLevelI;
  private final String expertiseII;
  private final int expertiseLevelII;
  private final String expertiseIII;
  private final int expertiseLevelIII;

  public Loading(String vorname, String nachname, String rolle, String abteilung,
      String expertiseI, int expertiseLevelI, String expertiseII,
      int expertiseLevelII, String expertiseIII, int expertiseLevelIII) {
    this.vorname = vorname;
    this.nachname = nachname;
    this.rolle = rolle;
    this.abteilung = abteilung;
    this.expertiseI = expertiseI;
    this.expertiseLevelI = expertiseLevelI;
    this.expertiseII = expertiseII;
    this.expertiseLevelII = expertiseLevelII;
    this.expertiseIII = expertiseIII;
    this.expertiseLevelIII = expertiseLevelIII;
  }

  public static String saveAndQuit() {
    return WQ;
  }

  public static String sprintCreationString(String name, String startDateString,
      String endDateString) {
    return "enter new sprint " + name + " enter start " + startDateString
        + " enter end " + endDateString + " store\n";
  }

  public static String sprintCreationString(String name, String startDateString,
      String endDateString, String expertiseI, int expertiseLevelI,
      String expertiseII, int expertiseLevelII) {
    return "enter new sprint " + name + " enter start " + startDateString
        + " enter end " + endDateString + " enter expertise " + expertiseI + " "
        + expertiseLevelI + " enter expertise " + expertiseII + " "
        + expertiseLevelII + " store\n";

  }

  public String toInputString() {
    return "enter new mitarbeiter " + vorname + " " + nachname + " " + rolle + " "
        + abteilung + " " + expertiseI + " " + expertiseLevelI + " " + expertiseII
        + " " + expertiseLevelII + " " + expertiseIII + " " + expertiseLevelIII
        + " ";
  }
}
