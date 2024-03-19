package lab3.task6;

public final class IntegerCalculatorResult extends CalculatorResult{
    public IntegerCalculatorResult(final CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }
    @Override
    public Object computeResult(){
        int leftOperand = (int) super.getRequest().getLeftOperand();
        int rightOperand = (int) super.getRequest().getRightOperand();
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
                    System.out.println("Division by zero");
                    return null;
                }
                return leftOperand / rightOperand;
            default:
                System.out.println("Wrong operation");
                return null;
        }
    }
}
