package org.hbrs.se.ws21.midterm.view;

import java.io.PrintStream;
import java.util.Map;
import java.util.Set;

public class ExpertiseView {

  public void dumpSorted(Map<String, Integer> expertise, PrintStream output) {
    String[][] tmp = listToStringarray(expertise.keySet());
    TablePrinter printer = new TablePrinter(tmp.length, tmp[0].length);
    printer.setTable(tmp, 40);
    printer.print(output);
  }

  protected String[][] listToStringarray(Set<String> exp) {
    int i = 1;
    String[][] table = new String[exp.size() + 1][1];
    table[0] = new String[]{"Expertise"};
    /**
     * EXPERTISEN WERDEN HIER ENTFERNT BZW NICHT BEACHTET.
     */
    for (String ex : exp) {
      table[i] = new String[]{"" + ex};
      i++;
    }
    return table;

  }

}
