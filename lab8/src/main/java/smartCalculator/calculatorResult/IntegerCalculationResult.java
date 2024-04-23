//package pao.blsalin.smartercalculator.calculatorResult;

//import pao.blsalin.smartercalculator.CalculationRequest;
//package lab8.task1.calculatorResult;
//import lab8.task1.CalculationRequest;
package smartCalculator.calculatorResult;
import smartCalculator.CalculationRequest;
public class IntegerCalculationResult extends AbstractCalculationResult {
    public IntegerCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() {
        CalculationRequest request = getRequest();
        String leftOperandStr = request.getLeftOperand().toString();
        String rightOperandStr = request.getRightOperand().toString();

        int leftOperand = Integer.parseInt(leftOperandStr);
        int rightOperand = Integer.parseInt(rightOperandStr);

        return switch (request.getOperation()) {
            case "+" -> leftOperand + rightOperand;
            case "-" -> leftOperand - rightOperand;
            case "*" -> leftOperand * rightOperand;
            case "/" -> leftOperand / rightOperand;
            default -> throw new IllegalArgumentException();
        };
    }

}
