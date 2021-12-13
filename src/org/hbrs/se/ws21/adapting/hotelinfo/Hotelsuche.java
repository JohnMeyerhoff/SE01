package org.hbrs.se.ws21.adapting.hotelinfo;

import java.util.Scanner;

public class Hotelsuche {
    Formatvorgaben[] quellen;
    // Speichert Referenzen auf Instanzen,
    // welche die Methode Suche(Suchauftrag): Suchergebnis
    // bereitstellen.
    public void console(Scanner sc){

        System.out.println("Bitte geben sie einen Preis an");
        int price = sc.nextInt();


        Suchauftrag x = new Suchauftrag(price);
       
        for (Formatvorgaben hotel : quellen) {
            hotel.suche(x);
        }
    }
    
}
