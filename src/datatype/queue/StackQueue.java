package datatype.queue;

import datatype.stack.ArrayStack;

public class StackQueue<T> implements Queue<T> {

    private final ArrayStack<T> left = new ArrayStack<>();
    private final ArrayStack<T> right = new ArrayStack<>();

    @Override
    public void add(T value) {
        left.push(value);
    }

    @Override
    public T poll() {
        assertSize();
        overlap();
        return right.pop();
    }

    @Override
    public T peek() {
        assertSize();
        overlap();
        return right.peek();
    }

    @Override
    public int size() {
        return left.size() + right.size();
    }

    @Override
    public boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }

    private void assertSize() {
        if (left.isEmpty() && right.isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
    }

    private void overlap() {
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
    }
}
