package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://www.hackerrank.com/contests/projector-algo-base-8-hw-5-zpun0n6c/challenges/an-even-tree
@SuppressWarnings("all")
public class AnEvenTree {

    public static void main(String[] args) {
        // CASE #1: 2
        List<List<Integer>> tree_test = new ArrayList<>();
        tree_test.add(0, Collections.emptyList());
        tree_test.add(1, Arrays.asList(2, 3, 6));
        tree_test.add(2, Arrays.asList(1, 5, 7));
        tree_test.add(3, Arrays.asList(1, 4));
        tree_test.add(4, Arrays.asList(3));
        tree_test.add(5, Arrays.asList(2));
        tree_test.add(6, Arrays.asList(1, 8));
        tree_test.add(7, Arrays.asList(2));
        tree_test.add(8, Arrays.asList(6, 9, 10));
        tree_test.add(9, Arrays.asList(8));
        tree_test.add(10, Arrays.asList(8));
        System.out.println(maxEdgesToRemove(tree_test));


        System.exit(0);

        // read inadds
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] raw = reader.readLine().split(" ");
            int n = Integer.parseInt(raw[0]);
            int m = Integer.parseInt(raw[1]);

            List<List<Integer>> tree = initTree(n);
            readTree(tree, m, reader);

            // algorithm
            System.out.println(maxEdgesToRemove(tree));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int maxEdges = 0;

    public static int maxEdgesToRemove(List<List<Integer>> tree) {
        dfs(tree, 1, new boolean[tree.size()]);
        return maxEdges;
    }

    private static int dfs(List<List<Integer>> tree, int head, boolean[] visited) {
        visited[head] = true;
        int nodesCount = 1;
        List<Integer> children = tree.get(head);
        for (Integer child : children) {
            if (!visited[child]) {
                int cnt = dfs(tree, child, visited);
                if (cnt % 2 == 0) {
                    maxEdges++;
                } else {
                    nodesCount += cnt;
                }
            }
        }
        return nodesCount;
    }

    private static List<List<Integer>> initTree(int n) {
        List<List<Integer>> tree = new ArrayList<>(n + 1);
        tree.add(0, Collections.emptyList());
        for (int i = 1; i <= n; i++) {
            tree.add(i, new ArrayList<>());
        }
        return tree;
    }

    private static void readTree(List<List<Integer>> tree, int m, BufferedReader reader) throws IOException {
        for (int i = 0; i < m; i++) {
            String[] edge = reader.readLine().split(" ");
            Integer a = Integer.valueOf(edge[0]);
            Integer b = Integer.valueOf(edge[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
    }
}
