package lab6.task1;

import java.util.Collections;
import java.util.List;

public class PartialGradeSorting implements SortingStrategy {
    @Override
    public void sort(List<Student> students) {
        Collections.sort(students, (s1, s2) -> Double.compare(s2.getPartialGrade(), s1.getPartialGrade()));
    }
    @Override
    public String getSortingMethod() {
        return "partiala";
    }
}
