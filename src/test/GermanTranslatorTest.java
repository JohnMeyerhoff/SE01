package test;

import controller.TranslatorFactory;
import controller.Translator;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GermanTranslatorTest {

    @Test
    public void zahlenNegativ() {
        // Äquivalenzklasse 1
        // <0
        // Soll eine Error-Ausgabe nach Spezifikation zurückgeben
        Translator zn = TranslatorFactory.gtFactory();

        for (int i = -1000; i < 0; i++) {
            assertEquals("Übersetzung der Zahl " + i + " nicht möglich (" + Translator.version + ")",
                    zn.translateNumber(i));
        }
    }

    @Test
    public void zahlenPositiv() {
        // Äquivalenzklasse 2
        // 0< zahl <=10
        // gültige eingaben
        Translator gt = TranslatorFactory.gtFactory();
        assertEquals("fünf", gt.translateNumber(5));
        String[] deutsch = { "null", "eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun",
                "zehn" };
        int i = 0;
        for (String d : deutsch) {
            assertEquals(d, gt.translateNumber(i++));
        }
    }

    @Test
    public void zahlenGross() {
        /**
         * <pre>
         * Äquivalenzklasse 3.
         * 10 < zahl .
         * ungültige eingaben, zahl zu gross.
         * </pre>
         */
        Translator gn = TranslatorFactory.gtFactory();
        for (int i = 11; i < 1000; i++) {
            assertEquals("Übersetzung der Zahl " + i + " nicht möglich (" + Translator.version + ")",
                    gn.translateNumber(i));
        }
    }
}
