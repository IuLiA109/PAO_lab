//package pao.blsalin.smartercalculator.requestMapper;
//package lab8.task1.requestMapper;
//import pao.blsalin.smartercalculator.CalculationRequest;
//import lab8.task1.CalculationRequest;
package smartCalculator.requestMapper;
import smartCalculator.CalculationRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class NumberCalculatorRequestMapper implements CalculatorRequestMapper {
    protected static final List<String> VALID_OPERATIONS = Arrays.asList("+", "-", "*", "/");

    @Override
    public Optional<CalculationRequest> tryMapRequest(String leftOperandString, String operatorString, String rightOperandString) {
        if (!isOperationValid(operatorString)) {
            return Optional.empty();
        }

        return mapNumbers(leftOperandString, operatorString, rightOperandString);
    }


    protected boolean isOperationValid(String operation) {
        return VALID_OPERATIONS.contains(operation);
    }

    protected abstract Optional<CalculationRequest> mapNumbers(String leftOperandString, String operatorString, String rightOperandString);
}
