package CrackingTheInterview.stack_and_queue;

import datatype.queue.Queue;
import datatype.queue.StackQueue;

import java.util.stream.IntStream;

/**
 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueViaStack {

    public static void main(String[] args) {
        Queue<Integer> q = new StackQueue<>();
        IntStream.range(1, 11).forEach(q::add);

        for (int i = 0; i < 10; i++) {
            System.out.print(q.poll() + " ");
        }
    }
}
