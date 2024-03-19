package lab3.task6;

public final class CalculatorRequest {
    private final Object leftOperand;
    private final Object rightOperand;
    private final String operation;

    public CalculatorRequest(final Object leftOperand, final Object rightOperand,final String operation){
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }

    public String getRequestType(){
        if (leftOperand instanceof Boolean && rightOperand instanceof Boolean) {
            return "Boolean";
        } else if (leftOperand instanceof Integer && rightOperand instanceof Integer) {
            return "Integer";
        } else if (leftOperand instanceof Double || rightOperand instanceof Double) {
            return "Double";
        }
        return "Unknown";
    }

    public Object getLeftOperand(){
        return leftOperand;
    }
    public Object getRightOperand(){
        return rightOperand;
    }
    public String getOperation(){
        return operation;
    }

    @Override
    public String toString(){
        return leftOperand + " " + operation + " " + rightOperand;
    }
}
