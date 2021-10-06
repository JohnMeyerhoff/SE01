package controller;

public class GermanTranslator implements Translator {

	public String translateNumber(int number) {
		if (number < 0)
			return "minus " + translateNumber(-number);
		if (number <= 20) {
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
		if (number < 100) {
			if (number % 10 == 0) {
				switch (number) {
					case 30:
						return "dreißig";
					case 40:
						return "vierzig";
					case 50:
						return "fünfzig";
					case 60:
						return "sechzig";
					case 70:
						return "siebzig";
					case 80:
						return "achzig";
					default:
						return "neunzig";
				}
			}else{//just for structure
				String einer = translateNumber(number % 10);
				String zehner = translateNumber(number- ( number% 10));
				return einer+"und"+zehner;
			}
		}
		return null;
	}

	/*
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo() {
		System.out.println("GermanTranslator c / o 2021 by John Meyerhoff");

	}
}
