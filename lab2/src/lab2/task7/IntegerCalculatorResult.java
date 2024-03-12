package lab2.task7;

public class IntegerCalculatorResult extends CalculatorResult{
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }
    @Override
    public Object computeResult(){
        int leftOperand = (int) calculatorRequest.getLeftOperand();
        int rightOperand = (int) calculatorRequest.getRightOperand();
        String operation = calculatorRequest.getOperation();

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
                return null;
        }
    }
}
