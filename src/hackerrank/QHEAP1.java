package hackerrank;

import datatype.heap.Heap;
import datatype.heap.MinHeap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerrank.com/contests/projector-algo-base-10-hw-3/challenges/qheap1
public class QHEAP1 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfQueries = Integer.parseInt(reader.readLine());
            String[] queries = new String[numOfQueries];
            for (int i = 0; i < numOfQueries; i++) {
                queries[i] = reader.readLine();
            }
            // algorithm
            execute(queries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void execute(String[] queries) {
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
