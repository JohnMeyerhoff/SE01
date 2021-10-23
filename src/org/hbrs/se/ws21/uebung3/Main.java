package org.hbrs.se.ws21.uebung3;

import org.hbrs.se.ws21.uebung3.Container;
import org.hbrs.se.ws21.uebung3.ExampleMember;
public class Main {

    public Container buildInstances(){
        Container objekt = null;
        Member a = new ExampleMember();
        Member b = new ExampleMember();
        Member c = new ExampleMember();
        Member d = new ExampleMember();
        Member e = new ExampleMember();
        try{

            objekt.addMember(a);
            objekt.addMember(a);
            objekt.addMember(c);
            objekt.addMember(d);
            objekt.addMember(e);
        }catch(Exception exx){
            exx.printStackTrace();
        }
            return objekt;
    }
    
}