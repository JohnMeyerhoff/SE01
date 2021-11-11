package org.hbrs.se.ws21.uebung3;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
public class ExampleMember implements Member {
    private static int uniqueCounter = 0;

    public ExampleMember() {
        this.internalID = uniqueCounter++;
    }

    private Integer internalID;

    @Override
    public Integer getID() {
        return this.internalID;
    }

    @Override
    public String toString() {
        return "Member (ID = " + getID() + ")";
    }
}