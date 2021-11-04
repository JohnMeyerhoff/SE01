package org.hbrs.se.ws21.uebung4.view;

import org.hbrs.se.ws21.uebung4.Container;
import org.hbrs.se.ws21.uebung4.ContainerException;
import org.hbrs.se.ws21.uebung4.Mitarbeiter;

public class TabellenAusgabe {

    public void tabelle(Container<Mitarbeiter> a){
        System.out.println("Vorname\t\t\t\tName\t\t\t\tAbteilung\t\t\t\tRolle\t\t\t\tExpertisen");
        for (Mitarbeiter m : a.getCurrentList()) {
            System.out.print(m.getVorname()+"\t\t\t\t");
            System.out.print(m.getName() + "\t\t\t\t");
            System.out.print(m.getAbteilung() + "\t\t\t\t");
            System.out.print(m.getRolle() + "\t\t\t\t");
            System.out.print(m.getExpertise() + "\t\t\t\t");

            //System.out.println(String.format("%30s %25s %10s %25s %10s %20s %20s", "Item", "|", "Price($)", "|", "Qty", "|", "ID"));
        }

    }
    
    public void tabelle(Container<Mitarbeiter> a, String exp) {
        
    }

    public static void main(String[] args) {
        Container<Mitarbeiter> a = Container.getInstance();
        try {
            a.addMember(new Mitarbeiter("Lisa", "Franz", "AB", "ABB", "BB"));
        } catch (ContainerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TabellenAusgabe b = new TabellenAusgabe();
        b.tabelle(a);
    }
}
    
    