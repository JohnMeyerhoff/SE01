package org.hbrs.se.ws21.adapting.legacy;

public class WeirdStringList {
    String[][] storage;

    public WeirdStringList() {
        this.storage = new String[1][15];
    }
    public String[][] getTheStuffInside(){
        return this.storage;
    }
}
