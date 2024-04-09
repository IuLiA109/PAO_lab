package lab6.task1;

import java.util.List;

public class Sort {
    private SortingStrategy sortingStrategy;

    public Sort(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void print(List<Student> students){
        String sortingMethod;
        int position = 1;
        sortingStrategy.sort(students);
        System.out.println("Sortare după cea mai mare nota " + sortingStrategy.getSortingMethod());
        for (Student student : students) {
            System.out.println(position++ + ". " + student);
        }
        System.out.println();

    }
}
