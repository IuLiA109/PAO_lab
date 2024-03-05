package lab1.task4;

public class DummyCalculator {
    //public int
    public static void calculate(String[] args){
        if(args.length != 3) return;
        //args[0] - elem; args[1] - operator; args[2] - elem
        int elem1i=0, elem2i=0;
        double elem1d=0.0 , elem2d=0.0 ;
        boolean elem1b=false, elem2b=false;

        int unuei  = 0, unued = 0, unueb = 0, doiei = 0, doied = 0, doieb = 0;

        if(args[0].length() == 1 && Character.isDigit(args[0].charAt(0))){
            elem1i = Integer.parseInt(args[0]);
            unuei = 1;
        }
        else if(args[0].equals("true") || args[0].equals("false")){
            elem1b = Boolean.parseBoolean(args[0]);
            unueb = 1;
        }
        else if(args[0].length() == 3 && Character.isDigit(args[0].charAt(0)) && Character.isDigit(args[0].charAt(2)) && args[0].charAt(1)=='.'){
            elem1d = Double.parseDouble(args[0]);
            unued = 1;
        }

        if(args[2].length() == 1 && Character.isDigit(args[2].charAt(0))){
            elem2i = Integer.parseInt(args[2]);
            doiei = 1;
        }
        else if(args[2].equals("true") || args[2].equals("false")){
            elem2b = Boolean.parseBoolean(args[2]);
            doieb = 1;
        }
        else if(args[2].length() == 3 && Character.isDigit(args[2].charAt(0)) && Character.isDigit(args[2].charAt(2)) && args[2].charAt(1)=='.'){
            elem2d = Double.parseDouble(args[2]);
            doied = 1;
        }

        //if(args[1].length() !=1) return;
        switch (args[1].charAt(0)) {
            case '+':
                if(args[1].length() ==1){
                    if (unuei == 1 && doiei == 1)
                        System.out.println(elem1i + elem2i);
                    if (unuei == 1 && doied == 1)
                        System.out.println(elem1i + elem2d);
                    if (unued == 1 && doiei == 1)
                        System.out.println(elem1d + elem2i);
                    if (unued == 1 && doied == 1)
                        System.out.println(elem1d + elem2d);
                }
                break;
            case '-':
                if(args[1].length() ==1) {
                    if (unuei == 1 && doiei == 1)
                        System.out.println(elem1i - elem2i);
                    if (unuei == 1 && doied == 1)
                        System.out.println(elem1i - elem2d);
                    if (unued == 1 && doiei == 1)
                        System.out.println(elem1d - elem2i);
                    if (unued == 1 && doied == 1)
                        System.out.println(elem1d - elem2d);
                }
                break;
            case '*':
                if(args[1].length() ==1) {
                    if (unuei == 1 && doiei == 1)
                        System.out.println(elem1i * elem2i);
                    if (unuei == 1 && doied == 1)
                        System.out.println(elem1i * elem2d);
                    if (unued == 1 && doiei == 1)
                        System.out.println(elem1d * elem2i);
                    if (unued == 1 && doied == 1)
                        System.out.println(elem1d * elem2d);
                }
                break;
            case '/':
                if(args[1].length() ==1) {
                    if (unuei == 1 && doiei == 1) {
                        if (elem2i == 0) System.out.println("Cannot divide by zero!");
                        else System.out.println(elem1i / elem2i);
                    }
                    if (unuei == 1 && doied == 1) {
                        if (elem2d == 0.0) System.out.println("Cannot divide by zero!");
                        else System.out.println(elem1i / elem2d);
                    }
                    if (unued == 1 && doiei == 1) {
                        if (elem2i == 0) System.out.println("Cannot divide by zero!");
                        else System.out.println(elem1d / elem2i);
                    }
                    if (unued == 1 && doied == 1) {
                        if (elem2d == 0.0) System.out.println("Cannot divide by zero!");
                        else System.out.println(elem1d / elem2d);
                    }
                }
                break;
            case '&':
                if(unueb==1 && doieb==1 && args[1].charAt(1) == '&')
                    System.out.println( elem1b && elem2b );
                break;
            case '|':
                if(unueb==1 && doieb==1 && args[1].charAt(1) == '|')
                    System.out.println( elem1b || elem2b );
                break;
        }
    }
}
