package org.hbrs.se.ws21.uebung2;

//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.

import java.util.ArrayList;

public class Container {

  ArrayList<Member> inhalt = new ArrayList<>();

  public void addMember(Member neu) throws ContainerException {
    boolean found = false;
    for (Member m : inhalt) {
      if (m.getID().equals(neu.getID())) {
        found = true;
      }
    }
    if (found) {
      throw new ContainerException("Das Member-Objekt mit der ID " + neu.getID()
          + " ist bereits vorhanden!");
    } else {
      inhalt.add(neu);
    }
  }

  public String deleteMember(Integer id) {
    if (this.size() == 0) {
      return "nothing to delete";
    }
    for (Member m : inhalt) {
      if (m.getID().equals(id)) {
        inhalt.remove(m);
        return "deleted";
      }
    }
    return "unchanged";
    // Welche Nachteileergeben sich aus ihrer Sicht
    // für ein solchen Fehler-handling
    // gegenüber einer Lösung mit Exceptions?
    // Return codes sollten keine Strings sein.
    // Bool wäre als return code okay, hier sind es jetzt
    // drei Werte zwischen denen entschieden werden muss,
    // welche sich jederzeit ändern könnten
  }

  public void dump() {
    for (Member x : this.inhalt) {
      System.out.println(x.toString());
    }
  }

  public int size() {
    return inhalt.size();
    // gegebene Methode von ArrayList
  }
}
