import lab9.task1.SortedListSet;
import lab9.task2.MyWordCounter;
import lab9.task2.WordCounter;

import java.util.Comparator;
import java.util.SortedSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        //task 1
        SortedListSet<Integer> set1 = new SortedListSet<>();
        set1.add(3);
        set1.add(1);
        set1.add(2);
        set1.add(4);
        set1.add(3);

        System.out.println("Set1 (ordine naturala): " + set1);

        System.out.println(set1.first());

        SortedSet<Integer> subset = set1.subSet(1, 3);
        System.out.println("SubSet(1, 3): " + subset);

        SortedSet<Integer> headSet = set1.headSet(3);
        System.out.println("HeadSet(3): " + headSet);

        SortedSet<Integer> tailSet = set1.tailSet(2);
        System.out.println("TailSet(2): " + tailSet);
        */

        //task2
        WordCounter wordCounter = new MyWordCounter();

        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Velit egestas dui id ornare arcu odio ut sem nulla. Facilisis mauris sit amet massa vitae tortor. Malesuada nunc vel risus commodo viverra maecenas accumsan. Amet est placerat in egestas. Arcu vitae elementum curabitur vitae nunc. Lobortis feugiat vivamus at augue eget. Maecenas ultricies mi eget mauris pharetra et ultrices neque. Etiam erat velit scelerisque in dictum non consectetur. Pharetra pharetra massa massa ultricies mi quis hendrerit dolor magna. Felis donec et odio pellentesque. Netus et malesuada fames ac turpis egestas sed tempus urna. Facilisis leo vel fringilla est ullamcorper eget nulla facilisi. Laoreet id donec ultrices tincidunt arcu non sodales.";

        wordCounter.parse(text);
        wordCounter.printWordCounts();
    }
}