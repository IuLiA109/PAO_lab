package lab3.task6;

public abstract class CalculatorResult {
    private final CalculatorRequest calculatorRequest;

    public CalculatorResult(final CalculatorRequest calculatorRequest){
        this.calculatorRequest = calculatorRequest;
    }
    public CalculatorRequest getRequest() {
        return calculatorRequest;
    }
    public abstract Object computeResult();
}
