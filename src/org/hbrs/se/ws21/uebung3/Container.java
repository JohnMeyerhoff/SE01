package org.hbrs.se.ws21.uebung3;

import java.io.Serializable;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
import java.util.ArrayList;
import java.util.List;

import org.hbrs.se.ws21.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws21.uebung3.persistence.PersistenceException.ExceptionType;


public class Container implements Serializable {
    ArrayList<Member> inhalt = new ArrayList<>();
    
    private static Container instance = null;

    private Container(){
        //default-Konstruktor überschrieben
        //Verwendung des singleton-Pattern
    }
    public static Container getInstance(){
        if(instance == null){
            instance = new Container();
        }
        return instance;
    }
    //von Klara:
    public void store() throws PersistenceException{
        List<Member> datenspeicher = null;
        int index = 0;
        if(inhalt == null || inhalt.size() == 0){
            throw new PersistenceException(ExceptionType.ImplementationNotAvailable, "Es gibt keine Objekte zum abspeichern.");
        //Ist das die korrekte Exception? Man muss die richtige wöhlen
        }
        for (Member objekt : inhalt) {
            datenspeicher.add(index, objekt);
            index++;
        } 

    }
    //von Klara:
    public void load() throws PersistenceException{
        if(instance.inhalt.size() != 0){

        }
    }

    public void addMember(Member neu) throws ContainerException {
        boolean found = false;
        for (Member m : inhalt) {
            if (m.getID().equals(neu.getID())) {
                found = true;
            }
        }
        if(found){
            throw new ContainerException("Das Member-Objekt mit der ID " + neu.getID() +" ist bereits vorhanden!");
        }else{
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

 

    public int size() {
        return inhalt.size();
        // gegebene Methode von ArrayList
    }
}
