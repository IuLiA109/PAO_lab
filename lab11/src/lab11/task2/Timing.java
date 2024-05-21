package lab11.task2;

import lab11.task1.FutureMethod;
import lab11.task1.ParallelMethod;
import lab11.task1.ThreadMethod;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Timing {

    public static void execute(List<Integer> numbers){
        int[] sizes = {10, 1000, 10000, 10000000};
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/lab11/task2/timing_results.txt"))) {
            for (int size : sizes) {
                writer.write("Size: " + size + "\n");

                long start = System.nanoTime();
                for (int number : numbers) {
                    int square = number * number;
                }
                long end = System.nanoTime();
                writer.write("Sequential: " + (end - start) / 1_000_000.0 + " ms\n");

                start = System.nanoTime();
                ThreadMethod.main(numbers);
                end = System.nanoTime();
                writer.write("Thread: " + (end - start) / 1_000_000.0 + " ms\n");

                start = System.nanoTime();
                ParallelMethod.main(numbers);
                end = System.nanoTime();
                writer.write("parallelStream: " + (end - start) / 1_000_000.0 + " ms\n");

                start = System.nanoTime();
                FutureMethod.main(numbers);
                end = System.nanoTime();
                writer.write("CompletableFuture: " + (end - start) / 1_000_000.0 + " ms\n");

                writer.write("\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
