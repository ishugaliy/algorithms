package hackerrank;

import datatype.heap.Heap;
import datatype.heap.MinHeap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

// https://www.hackerrank.com/contests/projector-algo-base-10-hw-3/challenges/qheap1
public class QHEAP1 {

    public static void main(String[] args) {
//        int[] values = {-20, -6, -14, 20, -12, 10, -4, 90};
//        int[] values = {3, -15, 7, 10, -8};
//        int[] values = {28, 4, 27, 32, 51, 17, 76, 40, 9, 2, 65, 86, 59, 57, 46};

        PriorityQueue<Integer> queue = new PriorityQueue();
        MinHeap heap = new MinHeap();

//        for (int v : values) {
//            queue.add(v);
//            heap.add(v);
//        }

        // POPULATE
        Random random = new Random();
        int[] values = new int[100_000];
        for (int i = 0; i < values.length; i++) {
            int v = random.nextInt();
            int idx = -1;
            for (int j = 0; j < values.length; j++) {
                if (values[j] == v) {
                    idx = j;
                    break;
                }
            }
            if (idx == -1) {
                queue.add(v);
                heap.add(v);
                values[i] = v;
            }
        }

        // REMOVE ITEMS
        for (int i = 0; i < 5_000; i ++) {
            int idx = random.nextInt(heap.size() - 1);
            queue.remove(values[idx]);
            heap.remove(values[idx]);
        }

        // CHECK SIZE
        if (queue.size() != heap.size()) {
            System.out.println(Arrays.toString(values));
            System.out.println(String.format("ERROR, size is not same h:q - [%d][%d]", heap.size(), queue.size()));
            throw new RuntimeException();
        }

        // CHECK POLL
        while (!queue.isEmpty() && !heap.isEmpty()) {
            int hm = heap.poll();
            int qm = queue.poll().intValue();
            if (hm != qm) {
                System.out.println(String.format("h:q - [%d][%d]", hm, qm));
            }

        }
    }

    private void execute(String[] queries) {
        Heap heap = new MinHeap();
        for (String q : queries) {
            String[] args = q.split(" ");
            int cmd = Integer.parseInt(args[0]);
            switch (cmd) {
                case 1:
                    heap.add(Integer.parseInt(args[1]));
                    break;
                case 2:
                    heap.remove(Integer.parseInt(args[1]));
                    break;
                case 3:
                    System.out.println(heap.peek());
                    break;
            }
        }
    }
}
