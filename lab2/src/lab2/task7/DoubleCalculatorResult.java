package lab2.task7;

public class DoubleCalculatorResult extends CalculatorResult{
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }
    @Override
    public Object computeResult(){
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
