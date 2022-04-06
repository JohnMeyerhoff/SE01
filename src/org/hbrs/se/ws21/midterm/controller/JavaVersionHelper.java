package org.hbrs.se.ws21.midterm.controller;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und John Meyerhoff bearbeitet worden.

public class JavaVersionHelper {
    /**
     * Not needed at the moment.
     */
    private JavaVersionHelper() {

    }

    public static int getVersion() {
        String version = System.getProperty("java.version");
        // Ignore version beginning with 1. dont care.
        int dot = version.indexOf(".");
        if (dot != -1) {
            version = version.substring(0, dot);
        }
        return Integer.parseInt(version);

    }

}
