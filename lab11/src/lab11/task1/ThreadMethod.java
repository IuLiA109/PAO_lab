package lab11.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadMethod {
    public static void main(List<Integer> numbers) {
        int numProcessors = Runtime.getRuntime().availableProcessors();

        int chunkSize = (int) Math.ceil(numbers.size() / (double) numProcessors);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numProcessors; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, numbers.size());
            List<Integer> sublist = numbers.subList(start, end);
            Thread thread = new Thread(new PowerCalculator(sublist));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
