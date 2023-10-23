package org.hbrs.se.ws21.composite;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

import java.io.UnsupportedEncodingException;

public class TextDocument extends GeneralDocument {

  private final Encoding coding;
  private final String text;

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

  public enum Encoding {
    UTF8 {
      @Override
      public String toString() {
        return "UTF-8";
      }
    },
    UTF16 {
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
    }
  }
}
