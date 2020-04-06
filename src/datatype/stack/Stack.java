package datatype.stack;

public interface Stack<T> {
    void push(T v);
    T pop();
    T peek();
    int size();
    boolean isEmpty();
}
