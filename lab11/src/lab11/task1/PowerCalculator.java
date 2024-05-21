package lab11.task1;

import java.util.List;

public class PowerCalculator implements Runnable {
    private final List<Integer> numbers;

    PowerCalculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            int square = number * number;
            System.out.println(number + "^2=" + square);
        }
    }
}
