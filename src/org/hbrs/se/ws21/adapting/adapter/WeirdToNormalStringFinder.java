package org.hbrs.se.ws21.adapting.adapter;

import org.hbrs.se.ws21.adapting.legacy.WeirdStringFinder;
import org.hbrs.se.ws21.adapting.legacy.WeirdStringList;
import org.hbrs.se.ws21.adapting.maincode.PerfectStringFinder;

public class WeirdToNormalStringFinder implements PerfectStringFinder {
    WeirdStringList wsl;

    public WeirdToNormalStringFinder(WeirdStringList wsl){
        this.wsl = wsl;
    }

    @Override
    public String find( int i) {
        String zuLang= new WeirdStringFinder(wsl).findemalbitte(i, 0);
        return zuLang.substring(7);
    }
    
}
