package lab2.task7;

public class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        boolean leftOperand = (boolean) calculatorRequest.getLeftOperand();
        boolean rightOperand = (boolean) calculatorRequest.getRightOperand();
        String operation = calculatorRequest.getOperation();

        switch (operation) {
            case "&&":
                return leftOperand && rightOperand;
            case "||":
                return leftOperand || rightOperand;
            default:
                return null;
        }
    }
}
