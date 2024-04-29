package lab9.task2;

import java.util.*;

public class MyWordCounter implements WordCounter{
private Map<String, Integer> wordCounts;

    public MyWordCounter() {
        this.wordCounts = new HashMap<>();
    }

    @Override
    public void parse(String text){
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
    }

    @Override
    public int getCount(String word) {
        return wordCounts.getOrDefault(word, 0);
    }

    @Override
    public SortedSet<String> getUniqueWords() {
        return new TreeSet<>(wordCounts.keySet());
    }

    @Override
    public void printWordCounts() {
        Comparator<String> comparator = (word1, word2) -> {
            int count1 = wordCounts.getOrDefault(word1, 0);
            int count2 = wordCounts.getOrDefault(word2, 0);
            if (count1 != count2) {
                return Integer.compare(count2, count1);
            } else {
                return word1.compareTo(word2);
            }
        };
        Map<String, Integer> sortedWordCounts = new TreeMap<>(comparator);
        sortedWordCounts.putAll(wordCounts);
        for (Map.Entry<String, Integer> entry : sortedWordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public void reset() {
        wordCounts.clear();
    }

}
