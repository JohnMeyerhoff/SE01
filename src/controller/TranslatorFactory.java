package controller;

public class TranslatorFactory {
    TranslatorFactory(){
        //Empty
    }
    public static GermanTranslator gtFactory() {
        return new GermanTranslator();
    }

}
