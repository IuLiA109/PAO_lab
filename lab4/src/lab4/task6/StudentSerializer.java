package lab4.task6;

import java.io.OutputStream;

public interface StudentSerializer {
    void serialize(OutputStream outputStream, Student student);
}