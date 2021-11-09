package org.hbrs.se.ws21.uebung4.test;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hbrs.se.ws21.uebung4.view.ConsoleUI;

public class ConsoleTest {

    @Test
    public void consoleSearchTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ConsoleUI ui = new ConsoleUI(ps);
        Scanner a = new Scanner("drucken\n");
        assertEquals("drucken", ui.searchDialogue(a));
        assertEquals("Bitte geben Sie eine von Ihnen gesuchte Expertise an.".trim(), os.toString().trim());
    }

    @Test
    public void consoleDumpTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ConsoleUI ui = new ConsoleUI(ps);
        ui.displayExpertiseFound("fertigkeit");
        assertEquals("Folgende Mitarbeiter haben die Expertise fertigkeit:".trim(), os.toString().trim());
    }

    @Test
    public void consoleExitTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ConsoleUI ui = new ConsoleUI(ps);
        Scanner a = new Scanner("drucken\n");
        assertEquals("drucken", ui.searchDialogue(a));
        assertEquals("Bitte geben Sie eine von Ihnen gesuchte Expertise an.".trim(), os.toString().trim());
    }

    @Test
    public void consoleTextonlyTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ConsoleUI ui = new ConsoleUI(ps);
        Scanner a = new Scanner("peter5 art1n MARTIN=COOL willi\n");
        String x = ui.textonlyDialogue(a, "den Vornamen");
        assertEquals("willi", x);
        String expected = "Bitte geben Sie den Vornamen ein.\n"
                + "Bitte geben sie hier nur Buchstaben ein.\n".repeat(3);
        String[] lines = os.toString().split("\n");
        String[] expectedlines = expected.split("\n");
        int i = 0;
        for (String str : lines) {
            assertEquals(expectedlines[i++].trim(), str.trim());
        }
    }

    @Test
    public void consoleTextonlyAsteriskTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ConsoleUI ui = new ConsoleUI(ps);
        Scanner a = new Scanner("*\n");
        String x = ui.textonlyDialogue(a, "den Abteilungsnamen (* für alle)");
        assertEquals("*", x);
        assertEquals("Bitte geben Sie den Abteilungsnamen (* für alle) ein.\n".trim(), os.toString().trim());
    }
}
