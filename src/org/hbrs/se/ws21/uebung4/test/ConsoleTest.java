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
        assertEquals("Bitte geben Sie eine von Ihnen gesuchte Expertise an.".trim(),os.toString().trim());
    }

    @Test
    public void consoleDumpTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ConsoleUI ui = new ConsoleUI(ps);
        ui.displayExpertiseFound("fertigkeit");
        assertEquals("Folgende Mitarbeiter haben die Expertise fertigkeit:".trim(),os.toString().trim());
    }

    @Test
    public void consoleExitTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ConsoleUI ui = new ConsoleUI(ps);
        Scanner a = new Scanner("drucken\n");
        assertEquals("drucken", ui.searchDialogue(a));
        assertEquals("Bitte geben Sie eine von Ihnen gesuchte Expertise an.".trim(),os.toString().trim());
    }

    @Test
    public void consoleTextonlyTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ConsoleUI ui = new ConsoleUI(ps);
        Scanner a = new Scanner("drucken\n");
        assertEquals("drucken", ui.searchDialogue(a));
        assertEquals("Bitte geben Sie eine von Ihnen gesuchte Expertise an.\n".trim(),os.toString().trim());
    }
}
