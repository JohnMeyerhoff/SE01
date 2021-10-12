package controller;

public class GermanTranslatorFactory {
    GermanTranslatorFactory() {
        // Empty
    }

    public static GermanTranslator gtFactory() {
        return new GermanTranslator();
    }

}
