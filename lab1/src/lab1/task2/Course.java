package lab1.task2;
import java.util.Random;

public class Course {
    private String name;
    private double minimumGrade;
    private Student[] students;

    public Course(String name, double minimumGrade, Student[] students) {
        this.name = name;
        this.minimumGrade = minimumGrade;
        this.students = students;
    }

    public Student chooseStudentRandomly() {
        Random random = new Random();
        int randomIndex = random.nextInt(students.length);
        return students[randomIndex];
    }

    public Student[] showAllPassingStudents() {
        int cnt = 0;
        for (Student student : students) {
            if (student.getGrade() >= minimumGrade) {
                cnt++;
            }
        }
        Student[] passing = new Student[cnt];
        int idx = 0;
        for (Student student : students) {
            if (student.getGrade() >= minimumGrade) {
                passing[idx] = student;
                idx++;
            }
        }
        return passing;
    }

    public boolean isStudentPassing(Student student) {
        for (Student s : students) {
            if (s.equals(student) && student.getGrade() >= minimumGrade) {
                return true;
            }
        }
        return false;
    }

    public boolean isStudentPassing(int idx) {
        if (idx >= students.length || idx < 0) return false;
        if (students[idx].getGrade() >= minimumGrade) {
            return true;
        }
        return false;
    }



}
