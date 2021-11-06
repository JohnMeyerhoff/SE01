package org.hbrs.se.ws21.uebung4;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
import java.util.Scanner;

import org.hbrs.se.ws21.uebung4.persistence.PersistenceException;

public class Client {
    Scanner suche = new Scanner(System.in);

    public int konsole(Container speicher) throws PersistenceException{
        String tmp;
        while(suche.hasNext()){
        tmp = suche.next();
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
            String parameter = suche.next();
            try{
            if(parameter.equals("merge")){
                speicher.merge();
            }else{
                speicher.force();
            }
            }catch(IllegalArgumentException e){
                System.out.println("Sie haben einen falschen Parameter angegeben.");
            }
        }

        if (tmp.equals("dump")) {
            MemberView a = new MemberView();
             a.dumpSorted(Container.getInstance().getCurrentListCopy());
        }

        //bergeunzung der zeichen noch ggf. anpassen!
        if(tmp.equals("enter")){ 

            System.out.println("Bitte geben Sie ihren Vornamen ein. ");
            String vorname = suche.next();
 
            System.out.println("Bitte geben Sie ihren Nachname ein. ");
            String name = suche.next();

            for (int i = 0; i < 10; i++) {
                //evtl noch nach Symbolen überprüfen!!
                if (name.contains(""+i)|| vorname.contains(""+i)){
                    System.out.println("Ungültige Eingabe für Ihren Vor- bzw. Nachname.\nBitte versuchen Sie es nochmal.");
                    break; //damit if-statement abbricht - neuer Verscuh im nächsten Schleifendurchlauf
                }
            }

            System.out.println("Bitte geben Sie ihre Rolle ein. ");
            String rolle = suche.next();

            System.out.println("Bitte geben Sie ihre Abteilung ein. ");
            String abteilung = suche.next();

            System.out.println("Bitte geben Sie ihre Expertise(n) ein. ");
            String expertisen = suche.next();
        }
        if(tmp.equals("search")){
         
        }


        System.out.println("Sie haben keine der gegebenen Befehle benutzt. "+ "\n"+ 
        "Geben Sie 'help' als Befehl ein, um alle Möglichkeiten zu sehen.");
         
        }
        return 5; //Eingabe beendet ohne exit
    }

}
