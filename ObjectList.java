import java.util.ArrayList;

public class ObjectList<T> extends ArrayList<T> {

    public boolean add(T value) {
        return super.add(value);
    }

    public T get(int index) {
        return super.get(index);
    }
}