package lab1.task2;

public class StudentAllocator {
    public static Student[] createStudents(int nr){
        Student[] students = new Student[nr];
        for (int i = 0; i < nr; i++) {
            String name = "Student " + (i + 1);
            double grade = Math.random() * 10;
            students[i] = new Student(name, grade);
            System.out.println(name + ' ' + grade);
        }
        return students;
    }
}
