package lab4.task2;

import java.util.ArrayList;
import java.util.List;

public class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args) {
        List<CalculatorResult> results = new ArrayList<>();
        List<CalculatorRequest> calcs = new ArrayList<>();

        try {
            if (args.length < 3 || args.length % 3 != 0) {
                throw new InvalidArgumentsLengthException("Invalid number of arguments provided.");
            }
        } catch (InvalidArgumentsLengthException e) {
            System.err.println("Invalid number of arguments: " + e.getMessage());
            return results;
        }

        try {
            calcs = InputConverter.mapRequests(args);
        } catch (UnknownOperandTypeException e) {
            System.err.println("Exception: " + e.getMessage());
        }

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
