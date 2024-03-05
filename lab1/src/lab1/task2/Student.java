package lab1.task2;

public class Student {
    private String name;
    private double grade;
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + "}";
    }
    public double getGrade(){
        return grade;
    }

}
