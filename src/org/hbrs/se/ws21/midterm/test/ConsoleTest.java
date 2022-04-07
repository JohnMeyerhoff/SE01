package org.hbrs.se.ws21.midterm.test;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hbrs.se.ws21.midterm.view.ConsoleUI;

public class ConsoleTest {

    @Test
    public void consoleSearchTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ConsoleUI ui = new ConsoleUI(ps);
        Scanner a = new Scanner("drucken\n");
        assertEquals("drucken", ui.searchDialogue(a));
        assertEquals("Bitte geben Sie eine von Ihnen gesuchte Expertise an. (Case-sensitive)".trim(),
                os.toString().trim());
    }

    @Test
    public void consoleDumpTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ConsoleUI ui = new ConsoleUI(ps);
        ui.displayExpertiseFound("fertigkeit");
        assertEquals("Folgende Mitarbeiter haben die Expertise fertigkeit:".trim(),
                os.toString().trim());
    }

    @Test
    public void consoleDisplayTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ConsoleUI ui = new ConsoleUI(ps);
        ui.displayWelcomeMessage();
        ui.displayHelpMessage();
        ui.displayGoodBye();
        ui.displayNothingFoundTable();
        ui.displayLoadSucessMessage();
        ui.displayExpertiseNotFound();
        ui.displayExpertiseFound("TESTSTRING");
        ui.displayInvalidCommandMessage();
        ui.displayLoadFailureMessage(new Exception("TEST"));

        ui.displayLoadFailureMessage(new ClassCastException("CCE MESSAGE"));

        String expected = """
                Willkommen im Sprint-Tool von Klara und John,
                Das Tool wurde für die SoGutWieKeinPlan GmbH entwickelt.
                Mit dem Befehl help erhalten Sie eine Übersicht.
                >Mögliche Befehle für Sie sind:
                enter
                store
                load
                dump
                search
                exit
                help
                Auf Wiedersehen
                +--------------------------+
                |Keine Mitarbeiter Gefunden|
                +--------------------------+
                Erfolgreich geladen.
                Leider wurden keine Mitarbeiter mit dieser Expertise gefunden.
                Folgende Mitarbeiter haben die Expertise TESTSTRING:

                Ihre Eingabe war kein gültiger Befehl.
                Sie können 'help' als Befehl eingeben, um alle Möglichkeiten zu sehen.
                Das laden war nicht erfolgreich.
                Das laden war nicht erfolgreich.
                Folgender Klassen-Ladefehler ist aufgetreten:
                CCE MESSAGE
                """;
        String[] lines = os.toString().split("\n");
        String[] expectedlines = expected.split("\n");
        int i = 0;
        for (String str : lines) {
            assertEquals(expectedlines[i++].trim(), str.trim());
        }
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
        assertEquals("Bitte geben Sie den Abteilungsnamen (* für alle) ein.\n".trim(),
                os.toString().trim());
    }
}
