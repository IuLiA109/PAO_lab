package lab4.task2;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {
    public static List<CalculatorRequest> mapRequests(String[] args) throws UnknownOperandTypeException{
        List<CalculatorRequest> calcs = new ArrayList<>();
        Object leftOperand = null;
        Object rightOperand = null;
        String operation;

        for (int i = 0; i < args.length; i += 3) {

            try {
                leftOperand = checkOperand(args[i]);
                rightOperand = checkOperand(args[i+2]);
                operation = args[i+1];

                CalculatorRequest request = new CalculatorRequest(leftOperand,rightOperand,operation);
                calcs.add(request);
            } catch (UnknownOperandTypeException e){
                System.err.println("Exception: " + e.getMessage() + " in " + args[i] + " " + args[i+1] + " " + args[i+2]);
            }
        }

        return calcs;
    }

    private static Object checkOperand(String operand) throws UnknownOperandTypeException{
        int notd = 0;
        int pct = 0;
        if(operand.equals("true") || operand.equals("false"))
            return Boolean.parseBoolean(operand);
        else{
            for(int j = 0; j < operand.length(); j++){
                if(!Character.isDigit(operand.charAt(j))){
                    if(operand.charAt(j) == '.') pct ++;
                    notd ++;
                }
            }
            if(notd == 0)
                return Integer.parseInt(operand);
            else if(notd ==1 && pct == 1)
                    return Double.parseDouble(operand);
            else
                throw new UnknownOperandTypeException(operand);
        }
    }


}
