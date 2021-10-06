package test;

import controller.TranslatorFactory;
import controller.Translator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GermanTranslatorTest {

    @Test
    public void zahlenNegativ() {
        // Äquivalenzklasse 2
        // <0
        // Soll eine Error-Ausgabe nach Spezifikation zurückgeben
        Translator zn = TranslatorFactory.gtFactory();
        assertThrows(IllegalArgumentException.class, () -> zn.translateNumber(-300));
        assertThrows(IllegalArgumentException.class, () -> zn.translateNumber(-7));
        assertThrows(IllegalArgumentException.class, () -> zn.translateNumber(-1));
    }

    @Test
    public void zahlenPositiv() {
        Translator gt = TranslatorFactory.gtFactory();
        assertEquals("fünf", gt.translateNumber(5));
        String[] deutsch = { "null", "eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun",
                "zehn" };
        int i = 0;
        for (String d : deutsch) {
            assertEquals(d, gt.translateNumber(i++));
        }
    }
}
