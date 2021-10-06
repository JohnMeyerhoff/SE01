package controller;

public class Factory {

    public Translator createTranslator() {
        return new GermanTranslator();
    }

}
