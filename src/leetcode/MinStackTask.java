package leetcode;

import datatype.stack.MinStack;

// https://leetcode.com/problems/min-stack/
public class MinStackTask {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();       // -3
        minStack.pop();          // -3
        minStack.peek();         // 0
        minStack.getMin();       // -2
    }
}
