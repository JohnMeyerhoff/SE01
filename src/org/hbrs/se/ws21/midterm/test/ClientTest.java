package org.hbrs.se.ws21.midterm.test;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.controller.Client;
import org.hbrs.se.ws21.midterm.model.Expertise;
import org.hbrs.se.ws21.midterm.model.Mitarbeiter;

public class ClientTest {

    MitarbeiterContainer c1;
    static Mitarbeiter m1;
    static Mitarbeiter m2;
    static Mitarbeiter m3;
    static final String STRICKEN = "Stricken";

    @BeforeAll
    public static void initialize() {
        Expertise a = new Expertise();
        Expertise b = new Expertise();
        Expertise c = new Expertise();
        a.putFaehigkeitLvl(STRICKEN, 1);
        a.putFaehigkeitLvl("Gehen", 2);
        a.putFaehigkeitLvl("Sitzen", 3);

        b.putFaehigkeitLvl(STRICKEN, 2);
        b.putFaehigkeitLvl("Leiden", 3);
        b.putFaehigkeitLvl("Programmieren", 1);

        c.putFaehigkeitLvl(STRICKEN, 2);
        c.putFaehigkeitLvl("Java", 2);
        c.putFaehigkeitLvl("Linux", 2);
        m1 = new Mitarbeiter("Artin", "Mueller", "Teamleiter", "Design", a);
        m2 = new Mitarbeiter("Martin", "Mayerr", "Abteilungsleiter", "Design", b);
        m3 = new Mitarbeiter("Wilhelm", "Mertens", "Teamleiter", "Engineering", c);
    }

    @BeforeEach
    public void destroy() {
        MitarbeiterContainer.developmentReset();
    }

    @Test
    public void enterTest() {
        c1 = MitarbeiterContainer.getInstance();
        Scanner sc = new Scanner(
                "enter Klara Golubovic pferd arrri skill 1 skill 2 skill 3 dump * store");
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        Client neu = new Client(c1, sc, ps);
        neu.konsole();

    }
}
