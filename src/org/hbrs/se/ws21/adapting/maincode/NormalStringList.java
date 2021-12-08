package org.hbrs.se.ws21.adapting.maincode;

public class NormalStringList {
    String[] storage;

    NormalStringList() {
        this.storage = new String[15];
    }
    public String[] getContent(){
        return this.storage;
    }
}
