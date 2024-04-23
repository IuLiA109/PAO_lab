//package pao.blsalin.smartercalculator.calculatorResult;

//import pao.blsalin.smartercalculator.CalculationRequest;
//package lab8.task1.calculatorResult;
//import lab8.task1.CalculationRequest;
package smartCalculator.calculatorResult;
import smartCalculator.CalculationRequest;

public class PrintingCalculationResult implements CalculationResult {

    private final CalculationResult calculationResult;

    public PrintingCalculationResult(CalculationResult calculationResult) {
        this.calculationResult = calculationResult;
    }

    @Override
    public Object computeResult() {
        Object result = calculationResult.computeResult();
        CalculationRequest request = calculationResult.getRequest();
        System.out.println("Operation " + request + " has result " + result);
        return result;
    }

    @Override
    public CalculationRequest getRequest() {
        return calculationResult.getRequest();
    }
}
