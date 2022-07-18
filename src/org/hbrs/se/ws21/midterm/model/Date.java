package org.hbrs.se.ws21.midterm.model;

import java.io.Serializable;

public class Date implements Serializable {

  private static final String[] MONATE = {"Januar", "Februar", "Maerz", "April", "Mai",
      "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
  private static char separator = '.';
  private static String order = "tmj";
  private final int year;
  private final int month;

  // -------------------------------------------------------------------------------------------------
  private final int day;

  public Date(int year, int month, int day) {
    validateDate(year, month, day);

    this.year = year;
    this.month = month;
    this.day = day;
  }

  public Date(Date datum) {
    this.year = datum.year;
    this.month = datum.month;
    this.day = datum.day;
  }

  // -------------------------------------------------------------------------------------------------

  private static void validateYear(int year) {
    if (year <= -500) {
      throw new IllegalArgumentException("Ungültiger Wert für Jahr: " + year);
    }
  }

  private static void validateMonth(int month) {
    if (month < 1 || 12 < month) {
      throw new IllegalArgumentException("Ungültiger Wert für Monat: " + month);
    }
  }

  // -------------------------------------------------------------------------------------------------

  private static void validateDate(int year, int month, int day) {
    if (day < 1 || daysInMonth(year, month) < day) {
      throw new IllegalArgumentException("Ungültiger Wert für Tag: " + day);
    }
  }

  public static void setFormatRF(String order) {
    if (!(order.equals("jmt") || order.equals("tmj") || order.equals("mtj"))) {
      throw new IllegalArgumentException(
          "Ungültiger Wert für Format-Reihenfolge: \"" + order + "\"");
    }

    Date.order = order;
  }

  public static void setFormatTZ(char seperator) {
    if (seperator == '\0') {
      return;
    }

    Date.separator = seperator;
  }

  // -------------------------------------------------------------------------------------------------

  public static String nameVonMonat(int monat) {
    validateMonth(monat);

    return MONATE[monat - 1];
  }

  public static int monatVonName(String monat) {
    for (int i = 0; i < MONATE.length; i++) {
      if (MONATE[i].equals(monat)) {
        return i + 1;
      }
    }

    throw new IllegalArgumentException(
        "Ungültiger Wert für Monat: \"" + monat + "\"");
  }

  // -------------------------------------------------------------------------------------------------

  public static boolean istSchaltjahr(int j) {
    validateYear(j);

    if (j < 1583 || j % 100 != 0) {
      return j % 4 == 0;
    }

    return j % 400 == 0;
  }

  public static int daysInMonth(int j, int m) {
    validateYear(j);
    validateMonth(m);

    switch (m) {
      case 2:
        return istSchaltjahr(j) ? 29 : 28;
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      default:
        return 31;
    }
  }

  // -------------------------------------------------------------------------------------------------

  public int jahr() {
    return year;
  }

  public int monat() {
    return month;
  }

  public int tag() {
    return day;
  }

  // -------------------------------------------------------------------------------------------------

  @Override
  public String toString() {
    String y = "" + year;
    String m = (month < 10 ? "0" : "") + month;
    String d = (day < 10 ? "0" : "") + day;
    String sep = "" + separator;

    if (separator == '0') {
      m = MONATE[month - 1];
      d += ".";
      sep = " ";
    }

    switch (order) {
      case "jmt":
        return String.join(sep, y, m, d); // y + sep + m + sep + d
      case "tmj":
        return String.join(sep, d, m, y);
      case "mtj":
        return String.join(sep, m, d, y);
      default:
        assert false : order;
        return "";
    }
  }

  // -------------------------------------------------------------------------------------------------

  @Override
  public boolean equals(Object o) {
    // two dates are equal iff their year, month and day are the same
    if (o instanceof Date datum) {
      return this == datum
          || year == datum.year && month == datum.month && day == datum.day;

    }
    return false;
  }

  public boolean istFrueher(Date datum) {
    return year < datum.year || year == datum.year
        && (month < datum.month || month == datum.month && day < datum.day);
  }
}
