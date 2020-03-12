package datatype.queue;

public class CircularDequeue {

    private final int[] arr;

    private int hp; // head pointer
    private int tp; // tail pointer
    private int size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public CircularDequeue(int k) {
        this.arr = new int[k];
        this.hp = k / 2;
        this.tp = k / 2;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == arr.length) return false;
        arr[hp--] = value;
        size++;
        if (hp < 0) hp = arr.length - 1;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == arr.length) return false;
        if (++tp > arr.length - 1) tp = 0;
        size++;
        arr[tp] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) return false;
        hp++;
        size--;
        if (hp > arr.length - 1) hp = 0;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) return false;
        tp--;
        size--;
        if (tp < 0) tp = arr.length - 1;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) return -1;
        int idx = hp + 1 <= arr.length - 1 ? hp + 1 : 0;
        return arr[idx];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) return -1;
//        int idx = tp - 1 >= 0 ? tp - 1 : arr.length - 1;
        return arr[tp];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }
}
