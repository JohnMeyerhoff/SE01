package org.hbrs.se.ws21.uebung3;

import org.hbrs.se.ws21.uebung3.Container;
public class Main {

    public Container buildInstances(){
        Container objekt = null;
        Member a;
        Member b;
        Member c;
        Member d;
        Member e;
        objekt.addMember(a);
        objekt.addMember(a);
        objekt.addMember(c);
        objekt.addMember(d);
        objekt.addMember(e);
        return objekt;

    }
    
}