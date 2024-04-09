package lab6.task1;

import java.util.Collections;
import java.util.List;

public class AverageGradeSorting implements SortingStrategy {
    @Override
    public void sort(List<Student> students) {
        Collections.sort(students, (s1, s2) -> Double.compare(s2.getAverageGrade(), s1.getAverageGrade()));
    }
    public String getSortingMethod() {
        return "medie";
    }
}
