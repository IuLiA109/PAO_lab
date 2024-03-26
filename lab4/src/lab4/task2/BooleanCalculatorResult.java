package lab4.task2;

public class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        boolean leftOperand = (boolean) super.getRequest().getLeftOperand();
        boolean rightOperand = (boolean) super.getRequest().getRightOperand();
        String operation = super.getRequest().getOperation();

        switch (operation) {
            case "&&":
                return leftOperand && rightOperand;
            case "||":
                return leftOperand || rightOperand;
            default:
                throw new InvalidOperationException("Invalid operation for boolean operands: " + operation);
        }
    }
}
