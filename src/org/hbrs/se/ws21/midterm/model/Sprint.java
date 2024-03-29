package org.hbrs.se.ws21.midterm.model;

import java.util.Map;
import org.hbrs.se.ws21.midterm.util.Dateconverter;

public class Sprint implements org.hbrs.se.ws21.midterm.model.Member {

  private static int counter = 0;
  private final Date start;
  private final Date end;
  private final Expertise expertise;
  private int id = -1;
  private String visibleName;

  // This public constructor could be troublesome because unlike the ui method it
  // will not
  // filter out the "forbidden" names containing anything but letters and numbers
  // this is currently okay, because the client did not specify a high level of
  // strictness.
  // In the future if this is an issue this could be solved by using the factory
  // method pattern.
  public Sprint(String s, String e, String sprintname) {
    this(getStringAsDate(new Dateconverter(), s),
        getStringAsDate(new Dateconverter(), e), sprintname);
  }

  // See comment above.
  public Sprint(Date s, Date e, String sprintname) {

    this.id = Math.max(Sprint.counter, SprintContainer.getInstance().getMaximumID()) + 1;
    Sprint.counter = this.id;
    this.start = s;
    this.end = e;
    this.visibleName = sprintname;
    this.expertise = new Expertise();
  }// See comment above.

  public Sprint(Date s, Date e, String sprintname, Expertise exp) {

    this.id = Math.max(counter, SprintContainer.getInstance().getMaximumID()) + 1;
    Sprint.counter = this.id;
    this.start = s;
    this.end = e;
    this.visibleName = sprintname;
    this.expertise = exp;
  }

  public static Date getStringAsDate(Dateconverter dc, String input) {
    // this could be adapted to enforce specific encoding standards by setting the
    // dateformat in the dc
    return dc.fromString(input);
  }

  @Override
  public Integer getID() {
    return this.id;
  }

  // basic getter without a corresponding setter
  public Date getEnd() {
    return this.end;
  }

  // basic getter without a corresponding setter
  public Date getStart() {
    return this.start;
  }

  // basic getter with a corresponding setter
  public String getVisibleName() {
    return visibleName;
  }

  // package private - not every class needs to be able to set Sprintnames (if
  // any)
  void setVisibleName(String newName) {
    this.visibleName = newName;
  }

  // duplicate of default getter but returns empty string if null
  // in this case the empty string is filled with 4 hyphons to signal the lack of
  // a name
  public String getVisibleNameESIN() {
    if (visibleName == null) {
      return "----";
    }
    return visibleName;
  }

  public Map<String, Integer> getExpertise() {
    return this.expertise.getErfahrungen();
  }

}
