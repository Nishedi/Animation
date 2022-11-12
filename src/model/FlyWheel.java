package model;

public class FlyWheel {

    int p0x = 300;
    int p0y = 300;
    int psx = 300+300;
    int psy = 300-100;
    double alpha = 0;
    int l1=100;
    int l2=500;

    public FlyWheel(int p0x, int p0y, int psx, int psy, int l1, int l2) {
        this.p0x = p0x;
        this.p0y = p0y;
        this.psx = psx;
        this.psy = psy;
        this.l1 = l1;
        this.l2 = l2;

    }
    public Double computeBeta(Double alpha){
        double beta = 0;
        int d = psx - p0x;
        int h = psy - p0y;
        double x1 = l1 * Math.cos(alpha);
        double y1 = l1 * Math.sin(alpha);
        double d1 = d - x1;
        double h1 = h - y1;
        double gamma = Math.atan2(h1,d1);
        beta = alpha - gamma;
        return beta;
    }
}