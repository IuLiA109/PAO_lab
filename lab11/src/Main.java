import lab11.task1.ThreadMethod;
import lab11.task2.Timing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static List<Integer> generateNumbers(int count) {
        List<Integer> numbers = new ArrayList<>(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(100) + 1);
        }
        return numbers;
    }

    public static void main(String[] args) {
        List<Integer> numbers = generateNumbers(10000);
        //task1
        //ThreadMethod.main(numbers);

        //task2
        Timing.execute(numbers);
    }
}