//package pao.blsalin.smartercalculator.calculatorResult;
//package lab8.task1.calculatorResult;
//import pao.blsalin.smartercalculator.CalculationRequest;
//import lab8.task1.CalculationRequest;
package smartCalculator.calculatorResult;
import smartCalculator.CalculationRequest;

public interface CalculationResult {
    Object computeResult();
    CalculationRequest getRequest();
}
