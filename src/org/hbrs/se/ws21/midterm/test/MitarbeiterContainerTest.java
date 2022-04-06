package org.hbrs.se.ws21.midterm.test;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.hbrs.se.ws21.midterm.model.exception.ContainerException;
import org.hbrs.se.ws21.midterm.model.exception.PersistenceException;
import org.hbrs.se.ws21.midterm.model.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se.ws21.midterm.model.persistence.PersistenceStrategyStream;
import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.model.Expertise;
import org.hbrs.se.ws21.midterm.model.Mitarbeiter;

public class MitarbeiterContainerTest {
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
    public void noStrategy() {
        c1 = MitarbeiterContainer.getInstance();
        assertEquals(0, c1.size());
        assertDoesNotThrow(() -> c1.addMember(m1));
        assertEquals(1, c1.size());
        PersistenceException exception = assertThrows(PersistenceException.class,
                () -> c1.store());
        assertEquals("Es gibt keine Strategie zum abspeichern.", exception.getMessage());
    }

    @Test
    public void mongoDBTest() {
        c1 = MitarbeiterContainer.getInstance();
        c1.setStrategy(new PersistenceStrategyMongoDB());
        assertEquals(0, c1.size());
        assertDoesNotThrow(() -> c1.addMember(m1));
        assertEquals(1, c1.size());
        PersistenceException exception = assertThrows(PersistenceException.class,
                () -> c1.store());
        assertEquals("Not implemented!", exception.getMessage());
    }

    @Test
    public void wrongLocation() {
        c1 = MitarbeiterContainer.getInstance();
        PersistenceStrategyStream<Mitarbeiter> stream = new PersistenceStrategyStream<>();
        String loc = "failDirectory/";
        stream.setLocation(loc);
        c1.setStrategy(stream);
        assertThrows(PersistenceException.class, () -> c1.load());
    }

    @Test
    public void einspeichernTest() {
        c1 = MitarbeiterContainer.getInstance();
        c1.setStrategy(new PersistenceStrategyStream<>());
        assertEquals(0, c1.size());
        assertDoesNotThrow(() -> c1.addMember(m1));
        assertEquals(1, c1.size());
        assertThrows(ContainerException.class, () -> c1.addMember(m1));
        assertThrows(ContainerException.class, () -> c1.addMember(m1));
        assertThrows(ContainerException.class, () -> c1.addMember(m1));
        assertEquals(1, c1.size());

        assertDoesNotThrow(() -> c1.addMember(m2));
        assertEquals(2, c1.size());
        assertDoesNotThrow(() -> c1.addMember(m3));
        assertEquals(3, c1.size());
        assertThrows(ContainerException.class, () -> c1.addMember(m2));
        assertThrows(ContainerException.class, () -> c1.addMember(m2));
        assertThrows(ContainerException.class, () -> c1.addMember(m2));
        assertThrows(ContainerException.class, () -> c1.addMember(m3));
        assertThrows(ContainerException.class, () -> c1.addMember(m3));
        assertThrows(ContainerException.class, () -> c1.addMember(m3));
        assertEquals(3, c1.size());

        assertDoesNotThrow(() -> c1.deleteMember(m3.getID()));
        assertEquals(2, c1.size());
        assertDoesNotThrow(() -> c1.addMember(m3));
        assertEquals(3, c1.size());

        assertDoesNotThrow(() -> c1.store());
        // empty the list
        assertDoesNotThrow(() -> c1.deleteMember(m3.getID()));
        assertEquals(2, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m2.getID()));
        assertEquals(1, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m1.getID()));
        assertEquals(0, c1.size());

        // load
        assertDoesNotThrow(() -> c1.load());
        assertEquals(3, c1.size());
        // empty the list
        assertDoesNotThrow(() -> c1.deleteMember(m3.getID()));
        assertEquals(2, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m2.getID()));
        assertEquals(1, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m1.getID()));
        assertEquals(0, c1.size());
        // load
        assertDoesNotThrow(() -> c1.load());
        assertEquals(3, c1.size());
        // empty the list
        assertDoesNotThrow(() -> c1.deleteMember(m3.getID()));
        assertEquals(2, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m2.getID()));
        assertEquals(1, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m1.getID()));
        assertEquals(0, c1.size());
        // load
        assertDoesNotThrow(() -> c1.load());
        assertEquals(3, c1.size());
    }

    @Test
    public void exceptionTest() {
        c1 = MitarbeiterContainer.getInstance();
        c1.setStrategy(new PersistenceStrategyStream<>());
        assertDoesNotThrow(() -> c1.addMember(m1));
        assertEquals(1, c1.size());
        ContainerException exception = assertThrows(ContainerException.class,
                () -> c1.addMember(m1));
        assertEquals(
                "Das Member-Objekt mit der ID " + m1.getID() + " ist bereits vorhanden!",
                exception.getMessage());
        c1.deleteMember(m1.getID());
    }

    @Test
    public void getCurrentTest() {
        c1 = MitarbeiterContainer.getInstance();
        c1.setStrategy(new PersistenceStrategyStream<>());
        assertDoesNotThrow(() -> c1.addMember(m1));
        assertEquals(c1.size(), c1.getCurrentList().size());
        assertDoesNotThrow(() -> c1.addMember(m2));
        assertEquals(c1.size(), c1.getCurrentList().size());
        assertDoesNotThrow(() -> c1.addMember(m3));
        assertEquals(c1.size(), c1.getCurrentList().size());
        assertEquals(3, c1.getCurrentList().size());
        List<Mitarbeiter> a = c1.getCurrentList();
        List<Mitarbeiter> b = c1.getCurrentListCopy();
        assertEquals(a.size(), b.size());
        Iterator<Mitarbeiter> aIterator = a.iterator();
        for (Mitarbeiter bElement : b) {
            assertEquals(bElement, aIterator.next());
        }

        for (Mitarbeiter deletionID : b) {
            assertEquals(1, c1.deleteMember(deletionID.getID()));
            if (c1.size() > 0) {
                assertEquals(0, c1.deleteMember(deletionID.getID()));
            } else {
                assertEquals(-1, c1.deleteMember(m1.getID()));
            }
        }
        // This test looks bad because the implementation
        // of deleteMember does not use exceptions
    }

}
