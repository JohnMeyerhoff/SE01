package view;

import controller.GermanTranslatorHelper;
import controller.Translator;

public class Client {
	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display(int nummer) {
		Translator generalTranslator = GermanTranslatorHelper.gtFactory();
		System.out.println("Ergebnis: " + 
			generalTranslator.
			translateNumber(nummer));
	}
}
