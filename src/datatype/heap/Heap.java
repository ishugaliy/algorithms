package datatype.heap;

public interface Heap {

    void add(int value);

    void remove(int v);

    int poll();

    int peek();

    int size();

    boolean isEmpty();
}
