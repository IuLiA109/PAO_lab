/*package org.example;

import smartCalculator.SmarterCalculator;
import smartCalculator.calculatorResult.PrintingCalculationResult;
import smartCalculator.*;
import smartCalculator.calculatorResult.AbstractCalculationResult;
import smartCalculator.calculatorResult.CalculationResult;
import smartCalculator.calculatorResult.PrintingCalculationResult;
import SmarterCalculatorWrapper;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/laborator";
        String username = "student";
        String password = "student";

        SmarterCalculatorWrapper resultSaver = new SmarterCalculatorWrapper(url, username, password);

        args = new String[]{"1", "+", "2", "2", "*", "5", "1", "+", "0.5", "1.0", "-", "2.0", "10.0", "/", "1", "true", "&&", "false"};

        List<CalculationResult> results = SmarterCalculator.calculate(args);

        for (CalculationResult res : results) {
            CalculationRequest req = res.getRequest();
            Object rasp = res.computeResult();

            System.out.println("Operation " + req + " has result " + rasp);
            resultSaver.saveResult(req, res);
        }
    }
}
*/