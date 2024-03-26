package lab4.task6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class RawDataStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) {
        // TODO 3:  Realizati serializarea pentru un singur student
        try (DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {
            dataOutputStream.writeUTF(student.getFullName());
            Map<String, Double> courseInformation = student.getCourseInformation();
            dataOutputStream.writeInt(courseInformation.size());

            for (Map.Entry<String, Double> entry : courseInformation.entrySet()) {
                dataOutputStream.writeUTF(entry.getKey());
                dataOutputStream.writeDouble(entry.getValue());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
