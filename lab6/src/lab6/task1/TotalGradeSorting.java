package lab6.task1;

import java.util.Collections;
import java.util.List;

public class TotalGradeSorting implements SortingStrategy {
    @Override
    public void sort(List<Student> students) {
        Collections.sort(students, (s1, s2) -> Double.compare(s2.getTotalGrade(), s1.getTotalGrade()));
    }
    public String getSortingMethod() {
        return "totala";
    }
}
