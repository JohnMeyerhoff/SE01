package org.hbrs.se.ws21.uebung4.test;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.hbrs.se.ws21.uebung4.model.exception.ContainerException;
import org.hbrs.se.ws21.uebung4.model.exception.PersistenceException;
import org.hbrs.se.ws21.uebung4.model.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se.ws21.uebung4.model.persistence.PersistenceStrategyStream;
import org.hbrs.se.ws21.uebung4.view.ConsoleUI;
import org.hbrs.se.ws21.uebung4.model.MitarbeiterContainer;
import org.hbrs.se.ws21.uebung4.model.Expertise;
import org.hbrs.se.ws21.uebung4.model.Mitarbeiter;

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

}