package org.hbrs.se.ws21.uebung4.view;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.

import java.io.PrintStream;

public class TablePrinter {

  private final String[][][] table;
  private final int rows;
  private final int cols;
  private int[] rowHeights;
  private int[] colWidths;

  public TablePrinter(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    table = new String[rows][cols][0];
  }

  public static void main(String[] args) {
    String[][] table = new String[][]{
        {"id", "First Name", "Last Name", "Age", "Profile"},
        {"1", "John", "Johnson", "45",
            "My name is John Johnson. My id is 1. My age is 45."},
        {"2", "Tom", "", "35", "My name is Tom. My id is 2. My age is 35."},
        {"3", "Rose",
            "Johnson Johnson Johnson Johnson Johnson Johnson Johnson Johnson Johnson Johnson",
            "22", "My name is Rose Johnson. My id is 3. My age is 22."},
        {"4", "Jimmy", "Kimmel", "",
            "My name is Jimmy Kimmel. My id is 4. My age is not specified. "
                + "I am the host of the late night show. I am not a fan of Matt Damon. "}};

    TablePrinter printer = new TablePrinter(table.length, table[0].length);
    printer.setTable(table, 40);
    printer.print(System.out);
  }

  public void setCell(int row, int col, String cell) {
    table[row][col] = cell.split("\n");
  }

  public void setRow(int row, String[] cells) {
    for (int col = 0; col < cols; col++) {
      setCell(row, col, cells[col]);
    }
  }

  public void setCol(int col, String[] cells) {
    for (int row = 0; row < rows; row++) {
      setCell(row, col, cells[row]);
    }
  }

  public void setTable(String[][] table) {
    for (int row = 0; row < rows; row++) {
      setRow(row, table[row]);
    }
  }

  public void setTable(String[][] table, int maxCellWidth, int splitMargin) {
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        String rest = table[row][col];
        String wrapped = "";

        while (rest.length() > maxCellWidth) {
          int splitIdx = rest.lastIndexOf(' ', maxCellWidth);
          String line;

          if (splitIdx < maxCellWidth - splitMargin) {
            line = rest.substring(0, maxCellWidth);
            rest = rest.substring(maxCellWidth);
          } else {
            line = rest.substring(0, splitIdx);
            rest = rest.substring(splitIdx + 1);
          }

          wrapped += line + '\n';
        }

        setCell(row, col, wrapped + rest);
      }
    }
  }

  public void setTable(String[][] table, int maxCellWidth) {
    setTable(table, maxCellWidth, 10);
  }

  private void calcCellSizes() {
    rowHeights = new int[rows];
    colWidths = new int[cols];

    for (int col = 0; col < cols; col++) {
      for (int row = 0; row < rows; row++) {
        if (table[row][col].length > rowHeights[row]) {
          rowHeights[row] = table[row][col].length;
        }

        for (String line : table[row][col]) {
          if (line.length() + 1 > colWidths[col]) {
            colWidths[col] = line.length() + 1;
          }
        }
      }
    }
  }

  public void print(PrintStream out) {
    calcCellSizes();

    String rowSep = "+";
    for (int col = 0; col < cols; col++) {
      rowSep += "-".repeat(colWidths[col]) + "+";
    }

    for (int row = 0; row < rows; row++) {
      out.println(rowSep);

      for (int line = 0; line < rowHeights[row]; line++) {
        for (int col = 0; col < cols; col++) {
          out.printf("|%-" + colWidths[col] + "s",
              line < table[row][col].length ? table[row][col][line] : "");
        }
        out.println('|');
      }
    }

    out.println(rowSep);
  }
}
