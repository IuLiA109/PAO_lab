package lab11.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelMethod {

    public static void main(List<Integer> numbers) {

        numbers.parallelStream().forEach(number -> {
            int square = number * number;
            System.out.println(number + "^2=" + square);
        });
    }
}
