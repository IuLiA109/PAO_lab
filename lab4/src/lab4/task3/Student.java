package lab4.task3;

import java.util.HashMap;
import java.util.Map;

public class Student implements Cloneable {
    private String fullName;
    private Map<String, Double> courseInformation;

    public Student(String fullName, Map<String, Double> courseInformation) {
        this.fullName = fullName;
        this.courseInformation = courseInformation;
    }

    @Override
    public Student clone() throws CloneNotSupportedException{
            Student cloned = (Student) super.clone();
            cloned.courseInformation = new HashMap<>(this.courseInformation);
            return cloned;
    }

    @Override
    public String toString() {
        return "Student{" + "fullName='" + fullName + '\'' + ", courseInformation=" + courseInformation + '}';
    }

}
