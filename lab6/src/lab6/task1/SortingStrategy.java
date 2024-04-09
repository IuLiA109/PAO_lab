package lab6.task1;

import java.util.List;

public interface SortingStrategy {
    void sort(List<Student> students);
    String getSortingMethod();
}
