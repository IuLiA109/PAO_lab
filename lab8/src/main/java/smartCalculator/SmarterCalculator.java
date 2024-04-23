//package pao.blsalin.smartercalculator;
//package lab8.task1;
//import pao.blsalin.smartercalculator.calculatorResult.BooleanCalculationResult;
//import pao.blsalin.smartercalculator.calculatorResult.AbstractCalculationResult;
//import pao.blsalin.smartercalculator.calculatorResult.CalculationResult;
//import pao.blsalin.smartercalculator.calculatorResult.DoubleCalculationResult;
//import pao.blsalin.smartercalculator.calculatorResult.IntegerCalculationResult;

//import lab8.task1.calculatorResult.BooleanCalculationResult;
//import lab8.task1.calculatorResult.AbstractCalculationResult;
//import lab8.task1.calculatorResult.CalculationResult;
//import lab8.task1.calculatorResult.DoubleCalculationResult;
//import lab8.task1.calculatorResult.IntegerCalculationResult;

package smartCalculator;
import smartCalculator.calculatorResult.BooleanCalculationResult;
import smartCalculator.calculatorResult.AbstractCalculationResult;
import smartCalculator.calculatorResult.CalculationResult;
import smartCalculator.calculatorResult.DoubleCalculationResult;
import smartCalculator.calculatorResult.IntegerCalculationResult;

import java.util.List;
import java.util.stream.Collectors;

public class SmarterCalculator {

    public static List<CalculationResult> calculate(String[] args) {
        return InputConverter.mapRequests(args)
                .stream()
                .map(SmarterCalculator::createCalculatorResponse)
                .collect(Collectors.toList());
    }

    private static CalculationResult createCalculatorResponse(CalculationRequest request) {
        return switch (request.getRequestType()) {
            case Boolean -> new BooleanCalculationResult(request);
            case Integer -> new IntegerCalculationResult(request);
            case Double -> new DoubleCalculationResult(request);
            default -> throw new IllegalArgumentException();
        };
    }
}
