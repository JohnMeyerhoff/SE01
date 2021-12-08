package org.hbrs.se.ws21.adapting.maincode;

import org.hbrs.se.ws21.adapting.adapter.WeirdToNormalStringFinder;
import org.hbrs.se.ws21.adapting.legacy.WeirdStringList;

public class UserConsole {
    public static void main(String[] args) {
        System.out.println("EXAMPLE:");
        WeirdStringList a = new WeirdStringList();
        NormalStringList b = new NormalStringList();

        WeirdToNormalStringFinder af = new WeirdToNormalStringFinder(a);
        ConcreteStringFinder bf = new ConcreteStringFinder(b);

        System.out.println(af.find(5));
        System.out.println(bf.find(5));
        System.out.println("Done.");
    }
}
