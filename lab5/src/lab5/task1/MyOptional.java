package lab5.task1;

import java.util.NoSuchElementException;

public class MyOptional<T> {
    private T value;

    private MyOptional(T value) {
        this.value = value;
    }

    public static <T> MyOptional<T> of(T value){
        return new MyOptional<>(value);
    }
    public boolean isPresent(){
        return value != null;
    }

    public T get(){
        if (!isPresent()) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }
}
