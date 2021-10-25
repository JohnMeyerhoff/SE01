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
import org.hbrs.se.ws21.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws21.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se.ws21.uebung3.persistence.PersistenceStrategyStream;

public class ContainerTest {
    Container c1;
    static Member m1;
    static Member m2;
    static Member m3;

    @BeforeAll
    public static void initialize() {
        m1 = new ExampleMember();
        m2 = new ExampleMember();
        m3 = new ExampleMember();
    }
    @BeforeEach
    public void destroy(){
        c1 = Container.getInstance();
        c1.developmentReset();
    }

    @Test
    public void noStrategy(){
        c1 = Container.getInstance();
        assertEquals(0, c1.size());
        assertDoesNotThrow(() -> c1.addMember(m1));
        assertEquals(1, c1.size());
        PersistenceException exception = assertThrows(PersistenceException.class, () ->c1.store());
        assertEquals("Es gibt keine Strategie zum abspeichern.", exception.getMessage());
    }

    @Test
    public void mongoDBTest(){
        c1 = Container.getInstance();
        c1.setStrategy(new PersistenceStrategyMongoDB());
        assertEquals(0, c1.size());
        assertDoesNotThrow(() -> c1.addMember(m1));
        assertEquals(1, c1.size());
        PersistenceException exception = assertThrows(PersistenceException.class, () ->c1.store());
        assertEquals("Not implemented!", exception.getMessage());
    }

    @Test
    public void einspeichernTest() {

        c1 = Container.getInstance();
        c1.setStrategy(new PersistenceStrategyStream());
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
        
        //store 
        assertDoesNotThrow(() -> c1.store()); 
        //empty the list
        assertDoesNotThrow(() -> c1.deleteMember(m3.getID()));
        assertEquals(2, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m2.getID()));
        assertEquals(1, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m1.getID()));
        assertEquals(0, c1.size());
      
        //load 
        assertDoesNotThrow(() -> c1.load()); 
        assertEquals(3, c1.size());
        //empty the list
        assertDoesNotThrow(() -> c1.deleteMember(m3.getID()));
        assertEquals(2, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m2.getID()));
        assertEquals(1, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m1.getID()));
        assertEquals(0, c1.size());
        //load 
        assertDoesNotThrow(() -> c1.load()); 
        assertEquals(3, c1.size());
        //assertDoesNotThrow(() -> c1.store()); 
        //empty the list
        assertDoesNotThrow(() -> c1.deleteMember(m3.getID()));
        assertEquals(2, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m2.getID()));
        assertEquals(1, c1.size());
        assertDoesNotThrow(() -> c1.deleteMember(m1.getID()));
        assertEquals(0, c1.size());
        //load 
        assertDoesNotThrow(() -> c1.load()); 
        assertEquals(3, c1.size());
    }
    
    /*@Test
    public void exceptionTest(){
        assertDoesNotThrow(() -> c1.addMember(m1));
        assertEquals(1, c1.size());
        ContainerException exception = assertThrows(ContainerException.class, () -> c1.addMember(m1));
        assertEquals("Das Member-Objekt mit der ID "+m1.getID()+" ist bereits vorhanden!", exception.getMessage());
        c1.deleteMember(m1.getID());
    }*/
}
