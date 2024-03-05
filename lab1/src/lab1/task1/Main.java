package lab1.task1;

import lab1.task2.Course;
import lab1.task2.Student;
import lab1.task2.StudentAllocator;
import lab1.task4.DummyCalculator;

public class Main {
    public static void main(String[] args) {
        /*Student[] students =  StudentAllocator.createStudents(5);
        Course course1 = new Course("PAO", 5, students);
        System.out.println(course1.chooseStudentRandomly().toString());
        System.out.println();
        Student[] passing = course1.showAllPassingStudents();
        for (Student student : passing) {
            if (student != null) {
                System.out.println(student.toString());
            }
        }
        System.out.println();
        System.out.println(course1.isStudentPassing(students[2]));
        System.out.println();
        System.out.println(course1.isStudentPassing(3));*/

        DummyCalculator.calculate(args);
    }
}
