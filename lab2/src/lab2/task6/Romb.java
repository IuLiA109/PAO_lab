package lab2.task6;

import static java.lang.Math.toRadians;

public class Romb extends Paralelogram{
    public Romb(int latura1,int unghi1, int unghi2) {
        super(latura1, latura1, unghi1, unghi2);
    }
    public double aria(){
        double diag1 = Math.sqrt(Math.pow(latura1,2) + Math.pow(latura2,2) - 2 * latura1 * latura2 * Math.cos(toRadians(unghi1)));
        double diag2 = Math.sqrt(Math.pow(latura3,2) + Math.pow(latura2,2) - 2 * latura3 * latura2 * Math.cos(toRadians(unghi2)));
        double result;
        result = diag1 * diag2 / 2;
        return result;
    }
}
