package leetcode;

import datatype.queue.CircularDequeue;

// https://leetcode.com/problems/design-circular-deque/
public class MyCircularDeque {

    public static void main(String[] args) {
        CircularDequeue q1 = new CircularDequeue(3);
        q1.insertLast(1);            // return true
        q1.insertLast(2);            // return true
        q1.insertFront(3);           // return true
        q1.insertFront(4);           // return false, the queue is full
        q1.getRear();                      // return 2
        q1.isFull();                       // return true
        q1.deleteLast();                   // return true
        q1.insertFront(4);           // return true
        q1.getFront();                     // return 4
    }
}
