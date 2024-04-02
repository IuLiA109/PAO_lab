//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import lab5.task1.*;
import lab5.task2.*;
import lab5.bonus.*;

import java.io.Serializable;
import java.util.*;
import java.util.function.Supplier;
/*
public class Main {
    public static void main(String[] args) {
        //task 1

        MyOptional<String> o1 = MyOptional.of(new String("asd"));
        System.out.println(o1.isPresent()); // true
        System.out.println(o1.get()); // "asd"

        MyOptional<Object> o2 = MyOptional.of(List.of("1", "2"));
        System.out.println(o2.isPresent()); // true
        System.out.println(o2.get()); // ["1", "2"]

        MyOptional<Serializable> o3 = MyOptional.of(null);
        System.out.println(o3.isPresent()); // false
        System.out.println(o3.get()); // NoSuchElementException

        //MyOptional<Integer> o4 = MyOptional.of("3"); // eroare de compilare
    }
}
*/

/*
//task 2
enum UniversityCode {
    POLITEHNICA_BUCHAREST
}

class Student {

    private final String fistName;
    private final String lastName;
    private final Integer age;
    private final Float grade;
    private final UUID teacherId;

    public Student(String fistName, String lastName, Integer age, Float grade, UUID teacherId) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.age = age;
        this.grade = grade;
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(fistName, student.fistName) && Objects.equals(lastName, student.lastName) && Objects.equals(age, student.age) && Objects.equals(grade, student.grade) && Objects.equals(teacherId, student.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fistName, lastName, age, grade, teacherId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}

class Teacher {

    private static final UniversityCode UNIVERSITY_CODE = UniversityCode.POLITEHNICA_BUCHAREST;
    private final String fistName;
    private final String lastName;
    private final List<String> subjects;
    private final UUID teacherId;

    public Teacher(String fistName, String lastName, List<String> subjects, UUID teacherId) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.subjects = subjects;
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(fistName, teacher.fistName) && Objects.equals(lastName, teacher.lastName) && Objects.equals(subjects, teacher.subjects) && Objects.equals(teacherId, teacher.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fistName, lastName, subjects, teacherId);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}

public class Main {

    private static final UUID coolTeacherId = UUID.randomUUID();
    private static final UUID notCoolTeacherId = UUID.randomUUID();
    private static Integer studentId = 0;
    private static Integer testNr = 0;

    private static final Supplier<Student> happyStudentSupplier = () ->
            createGenericStudent(studentId, "Happy", coolTeacherId, 10f);

    private static final Supplier<Student> sadStudentSupplier = () ->
            createGenericStudent(studentId, "Sad", notCoolTeacherId, 4.5f);

    public static void main(String[] args) {

        final Teacher coolTeacher = new Teacher(
                "Alex",
                "Amazing Teacher",
                Collections.singletonList("OOP"),
                coolTeacherId);

        final Teacher notSoCoolTeacher = new Teacher(
                "P",
                "GPL",
                Collections.singletonList("Good luck!"),
                notCoolTeacherId
        );

        final Teacher notCoolTeacher = new Teacher(
                "G.",
                "IUUU",
                Collections.singletonList("Good luck, you're going to need it!"),
                notCoolTeacherId
        );

        final List<Student> happyStudents = new ArrayList<>();
        final List<Student> sadStudents = new ArrayList<>();

        for (int i = 0; i < 10; ++i, ++studentId) {
            happyStudents.add(happyStudentSupplier.get());
            sadStudents.add(sadStudentSupplier.get());
        }

        // TEST PART, DO NOT MODIFY IT

        final MultiMapValue<Teacher, Student> multiMapValue = new MultiMapValue<>();

        printTestNr(); // 1
        System.out.println(multiMapValue.isEmpty());
        System.out.println(multiMapValue.size());
        System.out.println();

        final Student firstHappyStudent = happyStudentSupplier.get();
        multiMapValue.add(coolTeacher, firstHappyStudent);
        printTestNr(); // 2
        System.out.println(multiMapValue.isEmpty());
        System.out.println(multiMapValue.size());
        System.out.println();

        final Student secondHappyStudent = happyStudentSupplier.get();
        multiMapValue.add(coolTeacher, secondHappyStudent);
        printTestNr(); // 3
        System.out.println(multiMapValue.size());
        System.out.println();

        final Student firstSadStudentNotCoolTeacher = sadStudentSupplier.get();
        multiMapValue.add(notCoolTeacher, firstSadStudentNotCoolTeacher);
        final Student firstStudentNotSoCool = sadStudentSupplier.get();
        multiMapValue.add(notSoCoolTeacher, firstStudentNotSoCool);
        printTestNr(); // 4
        System.out.println(multiMapValue.size());
        System.out.println();

        printTestNr(); // 5
        System.out.println(multiMapValue.getValues(coolTeacher).size());
        System.out.println(multiMapValue.getValues(notCoolTeacher).size());
        System.out.println(multiMapValue.getValues(notSoCoolTeacher).size());
        System.out.println();

        multiMapValue.add(coolTeacher, happyStudentSupplier.get());
        multiMapValue.add(notCoolTeacher, sadStudentSupplier.get());
        multiMapValue.add(notSoCoolTeacher, sadStudentSupplier.get());
        multiMapValue.add(coolTeacher, happyStudentSupplier.get());
        printTestNr(); // 6
        System.out.println(multiMapValue.getValues(coolTeacher).size());
        System.out.println(multiMapValue.getValues(notCoolTeacher).size());
        System.out.println(multiMapValue.getValues(notSoCoolTeacher).size());
        System.out.println();

        printTestNr(); // 7
        System.out.println(multiMapValue.containsKey(coolTeacher));
        System.out.println(multiMapValue.containsKey(notCoolTeacher));
        System.out.println(multiMapValue.containsKey(notSoCoolTeacher));
        System.out.println();

        printTestNr(); // 8
        System.out.println(multiMapValue.getFirst(coolTeacher).equals(firstHappyStudent));
        System.out.println(multiMapValue.getFirst(notCoolTeacher).equals(firstSadStudentNotCoolTeacher));
        System.out.println(multiMapValue.getFirst(notSoCoolTeacher).equals(firstStudentNotSoCool));
        System.out.println();

        printTestNr(); // 9
        final List<Student> removedStudents = multiMapValue.remove(notSoCoolTeacher);
        removedStudents.forEach(student -> System.out.println(sadStudents.contains(student)));
        System.out.println(multiMapValue.size());
        System.out.println(multiMapValue.getFirst(notSoCoolTeacher));
        System.out.println();

        printTestNr(); // 10
        System.out.println(multiMapValue.getValues(coolTeacher).size());
        multiMapValue.addAll(coolTeacher, happyStudents);
        System.out.println(multiMapValue.getValues(coolTeacher).size());
        System.out.println(multiMapValue.getValues(notCoolTeacher).size());
        System.out.println();

        printTestNr(); // 11
        final MultiMapValue<Teacher, Student> addAllMultiMapValue1 = new MultiMapValue<>();
        addAllMultiMapValue1.addAll(notSoCoolTeacher, sadStudents);
        multiMapValue.addAll(addAllMultiMapValue1);
        System.out.println(multiMapValue.size());
        System.out.println(multiMapValue.getValues(coolTeacher).size());
        System.out.println(multiMapValue.getValues(notSoCoolTeacher).size());
        System.out.println(multiMapValue.getValues(notCoolTeacher).size());
        System.out.println();

        printTestNr(); // 12
        final List<Student> notSoCoolTeacherStudentsList = multiMapValue.getValues(notSoCoolTeacher);
        System.out.println(notSoCoolTeacherStudentsList.size());
        System.out.println(notSoCoolTeacherStudentsList.size() == sadStudents.size());
        System.out.println(notSoCoolTeacherStudentsList.containsAll(sadStudents));
        System.out.println();

        printTestNr(); // 13
        System.out.println();
        System.out.println(coolTeacher);
        multiMapValue.getValues(coolTeacher).forEach(System.out::println);
        System.out.println();
        System.out.println(notSoCoolTeacher);
        multiMapValue.getValues(notSoCoolTeacher).forEach(System.out::println);
        System.out.println();
        System.out.println(notCoolTeacher);
        multiMapValue.getValues(notCoolTeacher).forEach(System.out::println);

    }

    private static void printTestNr() {
        System.out.println("TEST " + ++testNr + " result:");
    }

    private static Student createGenericStudent(final Integer studentNr, final String firstName,
                                                final UUID teacherId, final Float grade) {
        return new Student(
                firstName + " " + studentNr,
                "Human Being",
                18,
                grade,
                teacherId);
    }
}
*/

//bonus
class Student implements Comparable<Student> {
    private final Float grade;

    public Student(Float grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student student) {
        return this.grade.compareTo(student.grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                '}';
    }
}

public class Main {

    private static Integer testNr = 0;

    public static void main(String[] args) {

        final Tree<Student> tree = new TreeImpl<>();
        final List<Student> studentList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            studentList.add(createGenericStudent((float) i));
        }

        printTestNr(); // 1
        System.out.println(tree.isEmpty());
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 2
        for (int i = 0; i < 5; i++) {
            tree.addValue(createGenericStudent((float) i));
        }
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 3
        tree.addAll(studentList);
        System.out.println(tree.isEmpty());
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 4
        final Student studentThatPassedExam = new Student(5.0f);
        final Student studentThatWorkedHardToPassTheExam = new Student(10.0f);
        final HashSet<Student> values = tree.getValues(studentThatPassedExam, studentThatWorkedHardToPassTheExam);
        System.out.println(values.size());
        values.stream().sorted().forEach(System.out::println);
    }

    private static void printTestNr() {
        System.out.println("TEST " + ++testNr + " result:");
    }

    private static Student createGenericStudent(final Float grade) {
        return new Student(grade);
    }
}