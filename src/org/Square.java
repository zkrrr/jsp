package org;

public class Square {
    public static final double PAI = 3.14;
    private double d;

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getC(){
        return this.d*2*PAI;
    }
    public double getS(){
        return this.d*this.d*PAI;
    }
}
