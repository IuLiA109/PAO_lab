
import lab2.task6.*;
import lab2.task7.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Paralelogram prl = new Paralelogram(20,10,60,120);
        Romb rmb = new Romb(20,30,150);
        Dreptunghi dr = new Dreptunghi(5,10);
        Patrat p = new Patrat(5);

        double aria1 = prl.aria();
        double aria2 = rmb.aria();
        double aria3 = dr.aria();
        double aria4 = p.aria();

        System.out.println("Aria paralelogramului este: " + aria1);
        System.out.println("Aria rombului este: " + aria2);
        System.out.println("Aria dreptunghiului este: " + aria3);
        System.out.println("Aria patratului este: " + aria4);
        */

        String[] inputArgs = {"1", "+", "2", "2", "*", "5", "1.0", "+", "5.0", "1.0", "-", "2.0", "10.0", "/", "1" , "true", "||", "false"};

        List<CalculatorResult> calculationResults = SmarterCalculator.calculate(inputArgs);

        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }

    }
}
