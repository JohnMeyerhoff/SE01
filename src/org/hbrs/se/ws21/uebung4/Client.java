package org.hbrs.se.ws21.uebung4;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
import java.util.Scanner;

import org.hbrs.se.ws21.uebung4.persistence.PersistenceException;

public class Client {
    Scanner suche = new Scanner(System.in);
    
    public int konsole() throws PersistenceException{
        String tmp = suche.next();
        while(suche.hasNext()){
        if(tmp.equals("help")){
            System.out.println(
            "Mögliche Befehle für Sie sind: "+ "\n" + 
            "enter,"+ "\n" +  
            "store,"+ "\n" + 
            "load,"+ "\n" + 
            "dump,"+ "\n" + 
            "search,"+ "\n" + 
            "exit,"+ "\n" + 
            "help"+ "\n");
        }
        if(tmp.equals("exit")){
            System.out.println("Auf Wiedersehen");
            return 0;
        }
        if(tmp.equals("store")){
            Container.getInstance().store();
        }
        if (tmp.equals("load")) {
            try{
            if(suche.next().equals("merge")){

            }else{

            }
            }catch(IllegalArgumentException e){
                throw new IllegalArgumentException("Sie haben einen falschen Parameter angegeben.");
            }
        }

        if (tmp.equals("dump")) {
            MemberView a = new MemberView();
             a.dumpSorted(Container.getInstance().getCurrentListCopy()))
        }
        
        System.out.println("Sie haben keine der gegebenen Befehle benutzt. "+ "\n"+ 
        "Geben Sie 'help' als Befehl ein, um alle Möglichkeiten zu sehen.");
        
        
        
        
        }
        return 5; //Eingabe beendet ohne exit
    }
}
