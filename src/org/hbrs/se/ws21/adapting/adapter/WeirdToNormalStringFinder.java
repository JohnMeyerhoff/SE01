package org.hbrs.se.ws21.adapting.adapter;

import org.hbrs.se.ws21.adapting.legacy.WeirdStringList;
import org.hbrs.se.ws21.adapting.maincode.PerfectStringFinder;

public class WeirdToNormalStringFinder implements PerfectStringFinder {
    WeirdStringList wsl;

    public WeirdToNormalStringFinder(WeirdStringList wsl){
        this.wsl = wsl;
    }

    @Override
    public String find( int i) {
        String[] content = wsl.getTheStuffInside()[0]; // THE ONLY DIFFERENCE
        for (String string : content) {
            if(string!=null && string.length()==i){
                return string;
            }
        }
        return "";
    }
    
}
