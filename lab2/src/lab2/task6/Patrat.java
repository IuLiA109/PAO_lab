package lab2.task6;

public class Patrat extends Dreptunghi{
    public Patrat(int latura1) {
        super(latura1, latura1);
    }

    public double aria(){
        double result;
        result = latura1 * latura1;
        return result;
    }
}
