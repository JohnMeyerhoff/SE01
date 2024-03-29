package org.hbrs.se.ws21.midterm.model;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und John Meyerhoff bearbeitet worden.
public class Mitarbeiter implements org.hbrs.se.ws21.midterm.model.Member {

  private static int uniqueCounter = 0;
  private String vorname;
  private String name;
  private String rolle;
  private String abteilung;
  private Expertise expertise;
  private Integer internalID;

  public Mitarbeiter(String vorname, String name, String rolle, String abteilung,
      Expertise expertise) {
    this.internalID = uniqueCounter++;
    this.name = name;
    this.rolle = rolle;
    this.abteilung = abteilung;
    this.expertise = expertise;
    this.vorname = vorname;
  }

  public String getVorname() {
    return this.vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRolle() {
    return this.rolle;
  }

  public void setRolle(String rolle) {
    this.rolle = rolle;
  }

  public String getAbteilung() {
    return this.abteilung;
  }

  public void setAbteilung(String abteilung) {
    this.abteilung = abteilung;
  }

  public Expertise getExpertise() {
    return this.expertise;
  }

  public void setExpertise(Expertise expertise) {
    this.expertise = expertise;
  }

  public Integer getInternalID() {
    return this.internalID;
  }

  public void setInternalID(Integer internalID) {
    this.internalID = internalID;
  }

  @Override
  public Integer getID() {
    return this.internalID;
  }

  @Override
  public String toString() {
    return "Member (ID = " + this.getID() + ")";
  }

}
