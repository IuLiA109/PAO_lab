package lab2.task7;

public class DoubleCalculatorResult extends CalculatorResult{
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }
    @Override
    public Object computeResult(){
        double leftOperand = ((Number) calculatorRequest.getLeftOperand()).doubleValue();
        double rightOperand = ((Number) calculatorRequest.getRightOperand()).doubleValue();
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
