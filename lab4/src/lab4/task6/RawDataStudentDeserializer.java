package lab4.task6;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class RawDataStudentDeserializer implements StudentDeserializer{
    @Override
    public Student deserializer(InputStream inputStream) {
        // TODO 4:  Realizati deserializarea pentru un singur student
        try (DataInputStream dataInputStream = new DataInputStream(inputStream)) {
            String fullName = dataInputStream.readUTF();
            int nrC = dataInputStream.readInt();

            Student student = new Student(fullName);
            for (int i = 0; i < nrC; i++) {
                String courseName = dataInputStream.readUTF();
                double grade = dataInputStream.readDouble();
                student.addCourseInformation(courseName, grade);
            }
            return student;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
