package org.hbrs.se.ws21.midterm.controller;

import org.hbrs.se.ws21.midterm.model.Mitarbeiter;
import org.hbrs.se.ws21.midterm.model.Sprint;

public class Match {
    private Heuristik heuristik;
    
    protected void setHeuristik(Heuristik h){
        this.heuristik = h;
    }

    public Match(Heuristik h){
        this.heuristik = h;
    }

    public double[] sprintAndMitarbeiter(Sprint sprint,Mitarbeiter[] mitarbeiter){
        return heuristik.sprintAndMitarbeiter(sprint, mitarbeiter);
    }
}
