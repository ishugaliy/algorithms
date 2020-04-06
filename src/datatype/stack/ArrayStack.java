package datatype.stack;

public class ArrayStack<T> implements Stack<T> {

    private Object[] arr = new Object[16];
    private int size = 0;

    @Override
    public void push(T v) {
        grow();
        arr[size++] = v;
    }

    @Override
    public T pop() {
        assertSize();
        return (T) arr[--size];
    }

    @Override
    public T peek() {
        assertSize();
        return (T) arr[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        if (size < arr.length - 1) return;

        Object[] tmp = new Object[arr.length * 2];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        arr = tmp;
    }

    private void assertSize() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }
}
