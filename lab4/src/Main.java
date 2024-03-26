import lab4.task2.*;
import lab4.task3.*;
import lab4.task6.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final static boolean runBonus = false;
    //task4
    public static void foo() {
        try {
            System.out.println("1");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("2");
        }
        System.out.println("3");
    }

    //task5
    public static void bar() {
        try {
            throw new ClassCastException();
        } catch (RuntimeException e) {
            try{
            }
            catch(RuntimeException a) {
                System.out.println("fail");
            }
        }
    }

    public static void main(String[] args) {
        /*
        //task2
        String[] inputArgs = {"1", "+", "2", "2", "*", "5", "1.0", "+", "5.0", "1.0", "-", "2.0", "10.0", "/", "10" , "true", "||", "false"};

        List<CalculatorResult> calculationResults = SmarterCalculator.calculate(inputArgs);

        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            try{
                Object rasp = result.computeResult();
                System.out.println("Operation " + request + " has result " + rasp);
            }
            catch (InvalidOperationException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
         */

        /*
        //task3
        Map<String, Double> courseInfo1 = new HashMap<>();
        Map<String, Double> courseInfo2 = new HashMap<>();

        courseInfo1.put("Mate", 9.5);
        courseInfo1.put("Info", 8.7);

        courseInfo2.put("Romana", 9.3);
        courseInfo2.put("Fizica", 5.9);

        Student student1 = new Student("Iulia", courseInfo1);
        Student student2 = new Student("Maria", courseInfo2);

        //inainte de clonare
        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);

        try {
            student2 = student1.clone();
        } catch (CloneNotSupportedException e){
            System.err.println("Exception: " + e.getMessage());
        }

        //dupa clonare
        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);
        */

        //task4
        //foo();

        //task5
        //bar();

        //task6
        StudentStorage storage;
        if (runBonus) {
            storage = getStorageForBonus();
        } else {
            storage = getStorageForTask6();
        }

        StudentSerializationTester tester = new StudentSerializationTester(storage);
        tester.runTests();

        runCustomTests(storage);
    }

    private static void runCustomTests(StudentStorage storage) {
        // TODO: Aici va puteti scrie teste proprii pentru verificarea corectitudinii
    }

    private static StudentStorage getStorageForTask6() {
        return new StudentStorage(new RawDataStudentSerializer(), new RawDataStudentDeserializer());
    }

    private static StudentStorage getStorageForBonus() {
        return new StudentStorage(new TextStudentSerializer(), new TextStudentDeserializer());
    }
}
