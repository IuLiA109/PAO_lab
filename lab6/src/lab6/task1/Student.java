package lab6.task1;

public class Student {
    private String name;
    private double lab_grade;
    private double partial_grade;
    private double exam_grade;

    public Student(String name, double lab_grade, double partial_grade, double exam_grade) {
        this.name = name;
        this.lab_grade = lab_grade;
        this.partial_grade = partial_grade;
        this.exam_grade = exam_grade;
    }

    public double getTotalGrade() {
        return lab_grade + partial_grade + exam_grade;
    }

    public double getPartialGrade() {
        return partial_grade;
    }

    public double getAverageGrade() {
        return this.getTotalGrade() / 3.0;
    }

    @Override
    public String toString() {
        return String.format("%s %.1f %.1f %.1f", name, lab_grade, partial_grade, exam_grade);
    }
}
