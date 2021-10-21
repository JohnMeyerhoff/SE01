package org.hbrs.se.ws21.uebung3.test;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.hbrs.se.ws21.uebung3.ContainerException;
import org.hbrs.se.ws21.uebung3.Container;
import org.hbrs.se.ws21.uebung3.ExampleMember;
import org.hbrs.se.ws21.uebung3.Member;

public class ContainerTest {
    Container c1;
    Member m1;
    Member m2;
    Member m3;

    @BeforeAll
    public void initialize() {
        c1 = Container.getInstance();
        m1 = new ExampleMember();
        m2 = new ExampleMember();
        m3 = new ExampleMember();
    }

    @Test
    public void einlesenTest() {
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

    }
    
    @Test
    public void exceptionTest(){
        assertDoesNotThrow(() -> c1.addMember(m1));
        assertEquals(1, c1.size());
        ContainerException exception = assertThrows(ContainerException.class, () -> c1.addMember(m1));
        assertEquals("Das Member-Objekt mit der ID "+m1.getID()+" ist bereits vorhanden!", exception.getMessage());
        try {
            c1.addMember(m1);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
    }
}
