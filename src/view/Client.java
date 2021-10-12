package view;

import controller.GermanTranslatorFactory;
import controller.Translator;

public class Client {
	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display(int nummer) {
		Translator generalTranslator = GermanTranslatorFactory.gtFactory();
		System.out.println("Ergebnis: " + generalTranslator.translateNumber(nummer));
	}
}
