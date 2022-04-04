package org.hbrs.se.ws21.midterm.util;


import org.hbrs.se.ws21.midterm.model.Date;

public class Dateconverter {

    public Date fromString(String dateString) {
        // System.out.println(dateString)
        String[] dateparts = dateString.split("[.]");
        Integer[] datenumbers = { 1, 1, 1 };
        datenumbers[0] = Integer.valueOf(dateparts[0]);
        datenumbers[1] = Integer.valueOf(dateparts[1]);
        datenumbers[2] = Integer.valueOf(dateparts[2]);
        
        return new Date(datenumbers[2], datenumbers[1], datenumbers[0]);

    }

}
