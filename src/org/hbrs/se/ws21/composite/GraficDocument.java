package org.hbrs.se.ws21.composite;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

public class GraficDocument extends CoreDocument {

  private static final int KONSTANTEBYTE = 1200;

  private final String url;

  public GraficDocument(String url) {
    this.url = url;
  }

  @Override
  public int getSizeInBytes() {
    return KONSTANTEBYTE;
  }

  public String getUrl() {
    return url;
  }
}
