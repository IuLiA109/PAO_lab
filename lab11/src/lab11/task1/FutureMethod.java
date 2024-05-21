package lab11.task1;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;

public class FutureMethod {

    public static void main(List<Integer> numbers) {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (Integer number : numbers) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                int square = number * number;
                System.out.println(number + "^2=" + square);
            }, executor);
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();
    }
}
