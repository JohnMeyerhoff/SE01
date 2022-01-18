package org.hbrs.se.ws21.uebung12;

public class MyPoint implements Comparable<MyPoint> {

    private double x;
    private double y;
    private static final double EPSILON = 0.0001d;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(MyPoint o) {
        if ((Math.abs(this.x - o.x) < EPSILON)) {
            return 0;
        } else {
            return (int) (this.y - o.y);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MyPoint other) {
            return ((Math.abs(this.y - other.y) < EPSILON)
                    && (Math.abs(this.x - other.x) < EPSILON));

        } else {
            return false;
        }

    }

    public MyPoint getHalfwayPoint(MyPoint upperRight) {
        return new MyPoint((this.x + upperRight.x) / 2, (this.y + upperRight.y) / 2);
    }

    public double getAreaFrom(MyPoint lowerLeft) {
        return ((this.x - lowerLeft.x) * (this.y - lowerLeft.y));
    }

    public double getperimeterFrom(MyPoint lowerLeft) {
        return (((this.x - lowerLeft.x) + (this.y - lowerLeft.y) )* 2);
    }

    public double getY() {
        return this.y;
    }

    public double getX() {
        return this.x;
    }

}
