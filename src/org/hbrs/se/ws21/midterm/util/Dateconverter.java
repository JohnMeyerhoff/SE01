package org.hbrs.se.ws21.midterm.util;

import java.text.ParseException;
import org.hbrs.se.ws21.midterm.model.Date;

public class Dateconverter {

    public Date fromString(String dateString) {
        //System.out.println(dateString)
        String[] dateparts = dateString.split("[.]");
        Integer[] datenumbers = {1,1,1};
        int i = 0;
        for (Integer integer : datenumbers) {
            datenumbers[i] =Integer.valueOf(dateparts[i++]);
        }
        return new Date(datenumbers[2], datenumbers[1], datenumbers[0]);

    }
    
}
