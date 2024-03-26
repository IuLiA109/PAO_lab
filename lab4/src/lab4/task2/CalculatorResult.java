package lab4.task2;

public class CalculatorResult {
    private final CalculatorRequest calculatorRequest;

    protected CalculatorResult(CalculatorRequest calculatorRequest){
        this.calculatorRequest = calculatorRequest;
    }
    public CalculatorRequest getRequest() {
        return calculatorRequest;
    }
    public  Object computeResult() throws InvalidOperationException{
        return null;
    }
}
