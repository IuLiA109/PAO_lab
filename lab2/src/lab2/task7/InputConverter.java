package lab2.task7;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {
    public static List<CalculatorRequest> mapRequests(String[] args) {
        List<CalculatorRequest> calcs = new ArrayList<>();
        Object leftOperand = null;
        Object rightOperand = null;
        String operation;
        int notd = 0;
        int pct = 0;

        for (int i = 0; i < args.length; i += 3) {
            notd = 0;
            pct = 0;
            operation = args[i + 1];

            if(args[i].equals("true") || args[i].equals("false"))
                leftOperand = Boolean.parseBoolean(args[i]);
            else{
                for(int j = 0; j < args[i].length(); j++){
                    if(!Character.isDigit(args[i].charAt(j))){
                        if(args[i].charAt(j) == '.') pct ++;
                        notd ++;
                    }
                }
                if(notd == 0)
                    leftOperand = Integer.parseInt(args[i]);
                if(notd ==1 && pct == 1)
                    leftOperand = Double.parseDouble(args[i]);
            }

            notd = 0;
            pct = 0;
            if(args[i+2].equals("true") || args[i+2].equals("false"))
                rightOperand = Boolean.parseBoolean(args[i+2]);
            else{
                for(int j = 0; j < args[i+2].length(); j++){
                    if(!Character.isDigit(args[i+2].charAt(j))){
                        if(args[i+2].charAt(j) == '.') pct ++;
                        notd ++;
                    }
                }
                if(notd == 0)
                    rightOperand = Integer.parseInt(args[i+2]);
                if(notd ==1 && pct == 1)
                    rightOperand = Double.parseDouble(args[i+2]);
            }


            CalculatorRequest request = new CalculatorRequest(leftOperand, rightOperand, operation);
            calcs.add(request);
        }

        return calcs;
    }
}
