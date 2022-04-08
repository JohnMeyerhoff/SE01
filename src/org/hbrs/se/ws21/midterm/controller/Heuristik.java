package org.hbrs.se.ws21.midterm.controller;

import org.hbrs.se.ws21.midterm.model.Mitarbeiter;
import org.hbrs.se.ws21.midterm.model.Sprint;

public interface Heuristik {
    public double[] sprintAndMitarbeiter(Sprint sprint, Mitarbeiter[] mitarbeiter);
}
