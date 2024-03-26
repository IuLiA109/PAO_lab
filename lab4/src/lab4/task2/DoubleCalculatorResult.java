package lab4.task2;

public class DoubleCalculatorResult extends CalculatorResult{
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }
    @Override
    public Object computeResult() throws InvalidOperationException{
        double leftOperand = ((Number) super.getRequest().getLeftOperand()).doubleValue();
        double rightOperand = ((Number) super.getRequest().getRightOperand()).doubleValue();
        String operation = super.getRequest().getOperation();

        switch (operation) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                if (rightOperand == 0) {
                    throw new InvalidOperationException("Division by zero");
                }
                return leftOperand / rightOperand;
            default:
                throw new InvalidOperationException("Invalid operation for double operands: " + operation);
        }
    }
}
