package uebung2.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uebung2.Container;
import uebung2.ContainerException;
import uebung2.ExampleMember;
import uebung2.Member;

public class ContainerTest {
    Container c1;
    Member m1;
    Member m2;
    Member m3;

    @BeforeEach
    public void initialize() {
        c1 = new Container();
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

        assertDoesNotThrow(() -> c1.addMember(m2));
        assertDoesNotThrow(() -> c1.addMember(m3));
        assertThrows(ContainerException.class, () -> c1.addMember(m2));
        assertThrows(ContainerException.class, () -> c1.addMember(m2));
        assertThrows(ContainerException.class, () -> c1.addMember(m2));
        assertThrows(ContainerException.class, () -> c1.addMember(m3));
        assertThrows(ContainerException.class, () -> c1.addMember(m3));
        assertThrows(ContainerException.class, () -> c1.addMember(m3));

        assertDoesNotThrow(() -> c1.deleteMember(m3.getID()));
        assertDoesNotThrow(() -> c1.addMember(m3));

    }
}
