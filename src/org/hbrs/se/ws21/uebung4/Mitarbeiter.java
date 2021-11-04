package org.hbrs.se.ws21.uebung4;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
public class Mitarbeiter implements org.hbrs.se.ws21.uebung4.Member {
    private static int uniqueCounter = 0;

    public Mitarbeiter() {
        this.internalID = uniqueCounter++;
    }
    private String vorname;
    private String name; 
    private String rolle;
    private String abteilung;
    private String expertise;
    private Integer internalID;

    @Override
    public Integer getID() {
        return this.internalID;
    }
    
    @Override
    public Integer getID() {
        return this.internalID;
    }
    @Override
    public Integer getID() {
        return this.internalID;
    }

    @Override
    public Integer getID() {
        return this.internalID;
    }
    @Override
    public Integer getID() {
        return this.internalID;
    }



    @Override
    public String toString() {
        return "Member (ID = " + getID() + ")";
    }
}