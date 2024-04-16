//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import lab7.task4.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //task 1
        /*
        //metoda 1
        try (FileInputStream file = new FileInputStream("C:/Users/Iulia/Desktop/PAO/lab7/src/lab7/task1/input.txt")) {
            file.skip(20);
            while (file.available() > 0) {
                System.out.print((char) file.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*
        //metoda 2
        try (FileInputStream file = new FileInputStream("C:/Users/Iulia/Desktop/PAO/lab7/src/lab7/task1/input.txt")) {
            char letter = ' ';
            while (file.available() > 0 && letter != '\n') {
                letter = (char) file.read();
            }
            while (file.available() > 0) {
                System.out.print((char) file.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*
        //task 2
        try {
            FileReader fileReader = new FileReader("C:/Users/Iulia/Desktop/PAO/lab7/src/lab7/task1/input.txt");

            while ((char)fileReader.read() != '\n');
            char[] charArray = new char[30];

            int i;
            while ((i = fileReader.read()) != -1) {
                System.out.print((char)i);
            }

            fileReader.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        */

        /*
        //task 3
        for(int i = 1; i<= 10; i++) {
            try (FileWriter fileWriter = new FileWriter("fisier" + i + ".txt")) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                fileWriter.write("Index: " + i + "\n");
                fileWriter.write("Data si ora: " + now.format(formatter));
            } catch (IOException e) {
                System.err.println("Eroare la scrierea în fisier");
            }
        }
        */

        /*
        //task 4
        int n = 20;
        IntStream.rangeClosed(2, n)
                .filter(nr -> nr % 2 == 0)
                .mapToObj(nr -> new NrAndSquare(nr, nr * nr))
                .forEach(System.out::println);
         */

        //task 5
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Intrare invalida!");
        }

        List<Integer> numere = new ArrayList<>();
        int i = 0;
        int i_init = 0;
        while(i < n) {
            int nr = 0;
            i_init = i;
            try {
                nr = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Intrare invalida!");
                i--;
            }
            i++;
            if(i > i_init) numere.add(nr);
        }

        List<DoubleUnaryOperator> operations = Arrays.asList(
                nr -> nr * 2,
                nr -> nr + 1,
                nr -> 1 / nr,
                nr -> nr * nr,
                nr -> (int) Math.sin(nr)
        );

        numere.forEach(number -> {
            Random random_nr = new Random();
            DoubleUnaryOperator operation = operations.get(random_nr.nextInt(operations.size()));
            double result = operation.applyAsDouble(number);
            System.out.println("Rezultat: " + result);
        });

    }
}