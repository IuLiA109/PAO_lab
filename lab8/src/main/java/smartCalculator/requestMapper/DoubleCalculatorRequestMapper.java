//package pao.blsalin.smartercalculator.requestMapper;
//package lab8.task1.requestMapper;
//import pao.blsalin.smartercalculator.CalculationRequest;
//import lab8.task1.CalculationRequest;
package smartCalculator.requestMapper;
import smartCalculator.CalculationRequest;
import java.util.Optional;

public class DoubleCalculatorRequestMapper extends NumberCalculatorRequestMapper {
    @Override
    protected Optional<CalculationRequest> mapNumbers(String leftOperandString, String operatorString, String rightOperandString) {
        try {
            Double leftOperand = Double.parseDouble(leftOperandString);
            Double rightOperand = Double.parseDouble(rightOperandString);

            return Optional.of(new CalculationRequest(leftOperand, rightOperand, operatorString));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
