package org.hbrs.se.ws21.adapting.legacy;

public class WeirdStringFinder {
    WeirdStringList wsl;

    public WeirdStringFinder(WeirdStringList wsl){
        this.wsl = wsl;
    }


    public String findemalbitte( int i,int dimension) {
        String[] content = wsl.getTheStuffInside()[dimension]; // THE ONLY DIFFERENCE
        for (String string : content) {
            if(string!=null && string.length()==i){
                return "AFFEHALLO"+string;
            }
        }
        return "AFFEHALLO"+"";
    }
}
