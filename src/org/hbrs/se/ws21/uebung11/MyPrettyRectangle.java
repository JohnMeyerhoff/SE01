package org.hbrs.se.ws21.uebung11;

public class MyPrettyRectangle {

  private final MyPoint lowerLeft;
  private final MyPoint upperRight;

  public MyPrettyRectangle(MyPoint ll, MyPoint ur) {
    if (ll.compareTo(ur) > 0) {
      this.lowerLeft = ur;
      this.upperRight = ll;
    } else {
      this.lowerLeft = ll;
      this.upperRight = ur;
    }
  }

  public MyPrettyRectangle(double d, double e, double f, double g) {
    this(new MyPoint(d, e), new MyPoint(f, g));
  }

  public boolean contains(MyPrettyRectangle potentialInner) {
    return (lowerLeft.compareTo(potentialInner.lowerLeft) <= 0)
        && (upperRight.compareTo(potentialInner.upperRight) >= 0);
  }

  public MyPoint getCenter() {
    return lowerLeft.getHalfwayPoint(upperRight);
  }

  public double getArea() {
    return Math.abs(upperRight.getAreaFrom(lowerLeft));
  }

  public double getPerimeter() {
    return Math.abs(upperRight.getperimeterFrom(lowerLeft));
  }

  public double getBottom() {
    return this.lowerLeft.getY();
  }

  public double getLeft() {
    return this.lowerLeft.getX();
  }

  public double getTop() {
    return this.upperRight.getX();
  }

  public double getRight() {
    return this.upperRight.getX();
  }

}
