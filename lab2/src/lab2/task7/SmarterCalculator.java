package lab2.task7;

import java.util.ArrayList;
import java.util.List;

public class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args){
        List<CalculatorResult> results = new ArrayList<>();
        List<CalculatorRequest> calcs = InputConverter.mapRequests(args);

        for (CalculatorRequest calc : calcs) {
            switch (calc.getRequestType()) {
                case "Boolean":
                    results.add(new BooleanCalculatorResult(calc));
                    break;
                case "Integer":
                    results.add(new IntegerCalculatorResult(calc));
                    break;
                case "Double":
                    results.add(new DoubleCalculatorResult(calc));
                    break;
                default:
                    System.out.println("Type not found!");
                    break;
            }
        }

        return results;
    }
}
