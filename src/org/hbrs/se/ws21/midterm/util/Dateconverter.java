package org.hbrs.se.ws21.midterm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.hbrs.se.ws21.midterm.model.Date;

public class Dateconverter {

    public Date fromString(String dateString) {
        SimpleDateFormat sfd = new SimpleDateFormat("dd.mm.yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sfd.parse(dateString));
        } catch (ParseException e) {
           
            e.printStackTrace();
        }
        return new Date(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 
                cal.get(Calendar.DAY_OF_MONTH));

    }
    
}
