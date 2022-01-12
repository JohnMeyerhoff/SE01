package org.hbrs.se.ws21.composite;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.
import java.io.UnsupportedEncodingException;

public class TextDocument extends GeneralDocument {

	public enum Encoding {
		UTF8 {
			@Override
			public String toString() {
				return "UTF-8";
			}
		},
		UTF16{
			@Override
			public String toString() {
				return "UTF-16";
			}
		},
		UTF32 {
			@Override
			public String toString() {
				return "UTF-32";
			}
		};

	}

	private Encoding coding;
	private String text;

	public TextDocument(String text, Encoding coding) {
		this.coding = coding;
		this.text = text;

	}

	@Override
	public int getSizeInBytes() {
		try {
			return text.getBytes(coding.toString()).length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return 1;
	}

}
