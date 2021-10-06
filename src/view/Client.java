package view;

import controller.GermanTranslatorHelper;

public class Client {
	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display(int nummer) {
		System.out.println("Ergebnis: " + 
			GermanTranslatorHelper.gtFactory().
			translateNumber(nummer));
	}
}
