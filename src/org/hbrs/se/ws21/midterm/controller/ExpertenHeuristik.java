package org.hbrs.se.ws21.midterm.controller;

import java.util.HashMap;
import java.util.Set;

import org.hbrs.se.ws21.midterm.model.Expertise;
import org.hbrs.se.ws21.midterm.model.Mitarbeiter;
import org.hbrs.se.ws21.midterm.model.Sprint;

public class ExpertenHeuristik implements Heuristik {

    @Override
    public double[] sprintAndMitarbeiter(Sprint sprint, Mitarbeiter[] mitarbeiter) {
        Set<String> sprintExpertise = sprint.getExpertise().keySet();
        double[] matchMeasures = new double[mitarbeiter.length];
        int i = 0;
        for (Mitarbeiter ma : mitarbeiter) {
            HashMap<String, Integer> mitarbeiterExpertise = ma.getExpertise().getErfahrungen();
            matchMeasures[i] = 0;
            for (String s : sprintExpertise) {
                matchMeasures[i] += mitarbeiterExpertise.getOrDefault(s, 0);
            }
            i++;
        }
        return matchMeasures;
    }
    
}
