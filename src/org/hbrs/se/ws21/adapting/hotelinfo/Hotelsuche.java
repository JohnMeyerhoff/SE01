package org.hbrs.se.ws21.adapting.hotelinfo;

import java.util.ArrayList;
import java.util.Scanner;

import org.hbrs.se.ws21.adapting.adapter.Adapter;

public class Hotelsuche {
    Formatvorgaben[] quellen;

    public Hotelsuche(Adapter adapter) {
        this.quellen = new Formatvorgaben[] { adapter };
    }

    // Speichert Referenzen auf Instanzen,
    // welche die Methode Suche(Suchauftrag): Suchergebnis
    // bereitstellen.
    public void console(Scanner sc) {

        System.out.println("Bitte geben sie einen Preis an");
        int price = sc.nextInt();

        Suchauftrag x = new Suchauftrag(price);
        ArrayList<Suchergebnis> sel = new ArrayList<>();
        for (Formatvorgaben hotel : quellen) {
            sel.add(hotel.suche(x));
        }

        System.out.println("Folgende Hotels haben wir gefunden:");
        for (Suchergebnis se : sel) {
            System.out.println(se);
        }
    }

}
