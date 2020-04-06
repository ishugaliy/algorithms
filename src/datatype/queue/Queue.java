package datatype.queue;

public interface Queue<T> {
    void add(T value);
    T poll();
    T peek();
    int size();
    boolean isEmpty();
}
