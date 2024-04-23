//package org.example;

import smartCalculator.SmarterCalculator;
import smartCalculator.calculatorResult.PrintingCalculationResult;
import smartCalculator.*;
import smartCalculator.calculatorResult.AbstractCalculationResult;
import smartCalculator.calculatorResult.CalculationResult;
import smartCalculator.calculatorResult.PrintingCalculationResult;
import task1.SmarterCalculatorWrapper;
import task2.ResultReader;
import task3.OperationTypeDeleter;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/laborator";
        String username = "student";
        String password = "student";
        /*
        //task 1
        SmarterCalculatorWrapper resultSaver = new SmarterCalculatorWrapper(url, username, password);

        args = new String[]{"1", "+", "2", "2", "*", "5", "1", "+", "0.5", "1.0", "-", "2.0", "10.0", "/", "1"};

        List<CalculationResult> results = SmarterCalculator.calculate(args);

        for (CalculationResult res : results) {
            CalculationRequest req = res.getRequest();
            Object rasp = res.computeResult();

            System.out.println("Operation " + req + " has result " + rasp);
            resultSaver.insertResult(req, res);
        }
        */

        /*
        //task2
        ResultReader reader = new ResultReader(url, username, password);
        List<CalculationResult> results = reader.readResults();

        for (CalculationResult result : results) {
            PrintingCalculationResult printingResult = new PrintingCalculationResult(result);
            printingResult.computeResult();
        }
        */

        /*
        //task3
        OperationTypeDeleter operationDeleter = new OperationTypeDeleter(url, username, password);
        operationDeleter.deleteOperation("Integer");
        */


    }
}
