package org.hbrs.se.ws21.midterm.model;

import org.hbrs.se.ws21.midterm.util.Dateconverter;

public class Sprint implements Member{
    private static int counter = 0;
    private int id=-1;
    private Date start;
    private Date end;
    
    public Sprint(String s, String e) {
        this.id = counter++;
        this.start = getStringAsDate(new Dateconverter(), s);
        this.end = getStringAsDate(new Dateconverter(), e);
    }
    
    public Sprint(Date s, Date e) {
        this.id = counter++;
        this.start =  s;
        this.end =  e;
    }
    
    @Override
    public Integer getID() {
        return this.id;
    }

    
    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }

    public Date getStringAsDate(Dateconverter dc,String input) {
        return dc.fromString(input);
    }


}
