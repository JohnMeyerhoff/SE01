package controller;

public class GermanTranslator implements Translator {

	public String translateNumber(int number) {
		if (number < 20) {
			switch (number) {
				case 1:
					return "eins";
				case 2:
					return "zwei";
				case 3:
					return "drei";
				case 4:
					return "vier";
				case 5:
					return "fünf";
				case 6:
					return "sechs";
				case 7:
					return "sieben";
				case 8:
					return "acht";
				case 9:
					return "neun";
				case 10:
					return "zehn";
				case 11:
					return "elf";
				case 12:
					return "zwölf";
				case 13:
					return "dreizehn";
				case 14:
					return "vierzehn";
				case 15:
					return "fünfzehn";
				case 16:
					return "sechzehn";
				case 17:
					return "siebzehn";
				case 18:
					return "achtzehn";
				case 19:
					return "neunzehn";
				case 20:
					return "zwanzig";
				default:
					return "null";
			}
		}
		return null;
	}

	/*
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo() {
		System.out.println("GermanTranslator c / o 2020 by HBRS");

	}
}
