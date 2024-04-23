//package pao.blsalin.smartercalculator.requestMapper;
//package lab8.task1.requestMapper;
//import pao.blsalin.smartercalculator.CalculationRequest;
//import lab8.task1.CalculationRequest;
package smartCalculator.requestMapper;
import smartCalculator.CalculationRequest;
import java.util.Optional;

public interface CalculatorRequestMapper {
    Optional<CalculationRequest> tryMapRequest(
            String leftOperandString,
            String operatorString,
            String rightOperandString);
}
