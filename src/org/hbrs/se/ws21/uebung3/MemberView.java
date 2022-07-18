package org.hbrs.se.ws21.uebung3;

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
}
