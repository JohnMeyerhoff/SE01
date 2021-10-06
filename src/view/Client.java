package view;

import controller.TranslatorFactory;
import controller.Translator;

public class Client {
	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display(int nummer) {
		Translator generalTranslator = TranslatorFactory.gtFactory();
		System.out.println("Ergebnis: " + 
			generalTranslator.
			translateNumber(nummer));
	}
}
