package org.hbrs.se.ws21.command.view;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

import org.hbrs.se.ws21.command.model.MitarbeiterContainer;
import org.hbrs.se.ws21.command.model.exception.ContainerException;
import org.hbrs.se.ws21.command.model.Expertise;
import org.hbrs.se.ws21.command.model.Mitarbeiter;

public class TabellenAusgabe {
    private static final String TABS = "\t\t\t\t";

    public void tabelle(MitarbeiterContainer a) {
        System.out.println(
                "Vorname\t\t\t\tName\t\t\t\tAbteilung\t\t\t\tRolle\t\t\t\tExpertisen");
        for (Mitarbeiter m : a.getCurrentList()) {
            System.out.print(m.getVorname() + TABS);
            System.out.print(m.getName() + TABS);
            System.out.print(m.getAbteilung() + TABS);
            System.out.print(m.getRolle() + TABS);
            System.out.print(m.getExpertise() + TABS);
        }
    }

    public static void main(String[] args) {
        MitarbeiterContainer a = MitarbeiterContainer.getInstance();
        Expertise x = new Expertise();
        MemberView f = new MemberView();
        f.dumpSorted(a.getCurrentListCopy());
        try {
            x.putFaehigkeitLvl("reinkacheln", 1);
            a.addMember(new Mitarbeiter("Lisa", "Franz", "AB", "ABB", x));
            a.addMember(new Mitarbeiter("Lisa", "Franz", "AB", "ABB", x));
        } catch (ContainerException e) {
            System.err.println(e.getMessage());
        }

        f.dumpSorted(a.getCurrentListCopy());
    }
}
