//package pao.blsalin.smartercalculator;
//package lab8.task1;
//import pao.blsalin.smartercalculator.requestMapper.BooleanCalculatorRequestMapper;
//import pao.blsalin.smartercalculator.requestMapper.CalculatorRequestMapper;
//import pao.blsalin.smartercalculator.requestMapper.DoubleCalculatorRequestMapper;
//import pao.blsalin.smartercalculator.requestMapper.IntegerCalculatorRequestMapper;
//import lab8.task1.requestMapper.BooleanCalculatorRequestMapper;
//import lab8.task1.requestMapper.CalculatorRequestMapper;
//import lab8.task1.requestMapper.DoubleCalculatorRequestMapper;
//import lab8.task1.requestMapper.IntegerCalculatorRequestMapper;
package smartCalculator;
import smartCalculator.requestMapper.BooleanCalculatorRequestMapper;
import smartCalculator.requestMapper.CalculatorRequestMapper;
import smartCalculator.requestMapper.DoubleCalculatorRequestMapper;
import smartCalculator.requestMapper.IntegerCalculatorRequestMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InputConverter {

    private static final List<CalculatorRequestMapper> MAPPERS = Arrays.asList(new BooleanCalculatorRequestMapper(), new IntegerCalculatorRequestMapper(), new DoubleCalculatorRequestMapper());

    public static List<CalculationRequest> mapRequests(String[] args) {
        if (args.length < 3 || args.length % 3 != 0) {
            throw new IllegalArgumentException();
        }

        List<CalculationRequest> calculatorRequests = new ArrayList<>();

        for (int i = 0; i < args.length; i += 3) {
            calculatorRequests.add(mapRequest(args[i], args[i + 1], args [i + 2]));
        }

        return calculatorRequests;
    }

    private static CalculationRequest mapRequest(
            String leftOperandString,
            String operatorString,
            String rightOperandString) {
        for (CalculatorRequestMapper mapper : MAPPERS) {
            Optional<CalculationRequest> calculatorRequestOptional = mapper.tryMapRequest(leftOperandString, operatorString, rightOperandString);
            if (calculatorRequestOptional.isPresent()) {
                return calculatorRequestOptional.get();
            }
        }

        return null;
    }



}
