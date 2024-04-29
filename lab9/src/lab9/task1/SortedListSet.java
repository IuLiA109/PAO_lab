package lab9.task1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.SortedSet;


public class SortedListSet<T extends Comparable<T>> extends LinkedList<T> implements SortedSet<T> {
    private Comparator<T> comparator;

    private int compare(T a, T b) {
        if (comparator == null) {
            return a.compareTo(b);
        } else {
            return comparator.compare(a, b);
        }
    }

    public SortedListSet() {
        this.comparator = null;
    }

    public SortedListSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Comparator<T> comparator() {
        return comparator;
    }

    public boolean add(T o){
        if (!contains(o)) {
            int index = 0;
            if (isEmpty() || comparator == null) {
                while (index < size() && get(index).compareTo(o) < 0) {
                    index++;
                }
                add(index, o);
            } else {
                while (index < size() && compare(get(index), o) < 0) {
                    index++;
                }
                add(index, o);
            }
            return true;
        }
        return false;
    }

    public T first() {
        return getFirst();
    }

    public T last() {
        return getLast();
    }

    public SortedSet<T> subSet(T from, T to) {
        SortedListSet<T> subset = new SortedListSet<>(comparator);
        for (T element : this) {
            if (compare(element, from) >= 0 && compare(element, to) <= 0) {
                subset.add(element);
            }
        }
        return subset;
    }

    public SortedSet<T> headSet(T to) {
        return subSet(first(), to);
    }

    public SortedSet<T> tailSet(T from) {
        return subSet(from, last());
    }
}
