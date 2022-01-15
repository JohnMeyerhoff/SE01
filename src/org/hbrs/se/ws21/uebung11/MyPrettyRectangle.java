package org.hbrs.se.ws21.uebung11;

public class MyPrettyRectangle {
    double rOX1;
    double rOY1;

    double lUX2;
    double lUY2;

    public MyPrettyRectangle(double Rx1,double Ry1, double Lx1, double Ly2){
    this.rOX1 = Rx1;
    this.rOY1 = Ry1;
    this.lUY2 = Ly2;
    this.lUX2 = Lx1;
    }

    public boolean contains(MyPrettyRectangle other){
        if(this.lUX2 < other.lUX2 && this.lUY2 < other.lUY2 && this.rOX1 > other.rOX1 && this.rOY1 > other.rOY1){
            return true;
        }
        return false;
    }

    public MyPoint getCenter(){
        double ySeite = this.lUX2 + this.rOX1;
        double mySeite = ySeite/2;
        double xSeite = this.lUY2 + this.rOY1;
        double mxSeite = xSeite/2;

        double mittelpunktX = rOX1 + mxSeite;
        double mittelpunktY = rOY1 +mySeite;

        return new MyPoint(mittelpunktX, mittelpunktY);
    }

    

    public double getArea(int r, int l){
        double ySeite = this.lUX2 + this.rOX1;
        double xSeite = this.lUY2 + this.rOY1;

        double flaeche = ySeite * xSeite;
        return flaeche;

    }
    public double boundingbox(){
        return 2.0;

    }
    public double testGetPerimeter(){
        double ySeite = this.lUX2 + this.rOX1;
        double xSeite = this.lUY2 + this.rOY1;
        double umfang = 2* ySeite + xSeite;
        return umfang;
    }

    public boolean sameIdentity(){
        return false;
    }
}
