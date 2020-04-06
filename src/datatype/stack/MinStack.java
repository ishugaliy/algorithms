package datatype.stack;

public class MinStack implements Stack<Integer> {

    private Entry[] arr;
    private int size = 0;

    public MinStack() {
        this(16);
    }

    public MinStack(int initialCapacity) {
        arr = new Entry[initialCapacity];
    }

    @Override
    public void push(Integer x) {
        grow();
        Entry e = Entry.of(x, findMin(x));
        arr[size++] = e;
    }

    @Override
    public Integer pop() {
        assertSize();
        return arr[--size].getValue();
    }

    @Override
    public Integer peek() {
        assertSize();
        return arr[size - 1].getValue();
    }

    public int size() {
        return size;
    }

    public int getMin() {
        assertSize();
        return arr[size - 1].getMin();
    }

    private void grow() {
        if (size < arr.length - 1) {
            return;
        }
        Entry[] tmp = new Entry[arr.length * 2];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        arr = tmp;
    }

    private int findMin(int newValue) {
        return size > 0
                ? Math.min(arr[size - 1].getMin(), newValue)
                : newValue;
    }

    private void assertSize() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private static class Entry {
        private int value;
        private int min;

        private Entry(int value, int min) {
            this.value = value;
            this.min = min;
        }

        public static Entry of(int value, int min) {
            return new Entry(value, min);
        }
        public int getValue() {
            return value;
        }
        public int getMin() {
            return min;
        }
    }
}

