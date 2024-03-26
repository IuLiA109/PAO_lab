package lab4.task6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public final class StudentStorage {
    private final StudentSerializer serializer;
    private final StudentDeserializer deserializer;

    public StudentStorage(StudentSerializer serializer, StudentDeserializer deserializer) {
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public List<Student> readAllStudents(InputStream inputStream) {
        // TODO 6: Cu ajutorul deserializatorului, cititi din sursa studentii
        List<Student> students = new ArrayList<>();
        Student student;
        while ((student = deserializer.deserializer(inputStream)) != null) {
            students.add(student);
        }
        return students;
    }

    public void writeAllStudents(OutputStream outputStream, List<Student> students) {
        // TODO 5: Cu ajutorul serializatorului, scrieti in sursa studentii
        for (Student student : students) {
            serializer.serialize(outputStream, student);
        }
    }
}
