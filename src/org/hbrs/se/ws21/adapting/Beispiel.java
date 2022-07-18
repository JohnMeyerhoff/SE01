package org.hbrs.se.ws21.adapting;

import java.util.Scanner;
import org.hbrs.se.ws21.adapting.adapter.Adapter;
import org.hbrs.se.ws21.adapting.hotelinfo.Hotelsuche;

public class Beispiel {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Hotelsuche hs = new Hotelsuche(new Adapter());
    hs.console(sc);
  }
}
