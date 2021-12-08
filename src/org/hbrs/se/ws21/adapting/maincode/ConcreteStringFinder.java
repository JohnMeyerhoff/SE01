package org.hbrs.se.ws21.adapting.maincode;

public class ConcreteStringFinder implements PerfectStringFinder {
    NormalStringList nsl;

    ConcreteStringFinder(NormalStringList nsl){
        this.nsl = nsl;
    }


    @Override
    public String find(int i) {
        String[] content =        nsl.getContent();
        for (String string : content) {
            if(string!=null && string.length()==i){
                return string;
            }
        }
        return "";
    }
    
}
