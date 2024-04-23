//package pao.blsalin.smartercalculator.calculatorResult;

//import pao.blsalin.smartercalculator.CalculationRequest;
//package lab8.task1.calculatorResult;
//import lab8.task1.CalculationRequest;
package smartCalculator.calculatorResult;
import smartCalculator.CalculationRequest;

public class BooleanCalculationResult extends AbstractCalculationResult {
    public BooleanCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() {
        CalculationRequest request = getRequest();
        String leftOperandStr = request.getLeftOperand().toString();
        String rightOperandStr = request.getRightOperand().toString();

        boolean leftOperand = Boolean.parseBoolean(leftOperandStr);
        boolean rightOperand = Boolean.parseBoolean(rightOperandStr);

        return switch (request.getOperation()) {
            case "&&" -> leftOperand && rightOperand;
            case "||" -> leftOperand || rightOperand;
            default -> throw new IllegalArgumentException();
        };
    }
}
