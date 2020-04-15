package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://www.hackerrank.com/contests/projector-algo-base-8-hw-5-zpun0n6c/challenges/optimal-trap-placement-tree
@SuppressWarnings("all")
public class OptimalTrapPlacementOnTree {

    public static void main(String[] args) {
        // CASE #1: 14
        int[] values = {0, 4, 5, 6, 4, 5};
        List<List<Integer>> tree = new ArrayList<>();
        tree.add(0, Collections.emptyList());
        tree.add(1, new ArrayList<>(Arrays.asList(2)));
        tree.add(2, new ArrayList<>(Arrays.asList(1, 3, 4)));
        tree.add(3, new ArrayList<>(Arrays.asList(2, 5)));
        tree.add(4, new ArrayList<>(Arrays.asList(2)));
        tree.add(5, new ArrayList<>(Arrays.asList(3)));
        System.out.println(maxTrapValue(tree, values));

        // CASE #2: 10
        values = new int[]{0, 3, 10, 3, 3};
        tree = new ArrayList<>();
        tree.add(0, Collections.emptyList());
        tree.add(1, new ArrayList<>(Arrays.asList(2)));
        tree.add(2, new ArrayList<>(Arrays.asList(1, 3, 4)));
        tree.add(3, new ArrayList<>(Arrays.asList(2)));
        tree.add(4, new ArrayList<>(Arrays.asList(2)));

        System.out.println(maxTrapValue(tree, values));

        // CASE #3: 9
        values = new int[]{0, 3, 8, 3, 3};
        tree = new ArrayList<>();
        tree.add(0, Collections.emptyList());
        tree.add(1, new ArrayList<>(Arrays.asList(2)));
        tree.add(2, new ArrayList<>(Arrays.asList(1, 3, 4)));
        tree.add(3, new ArrayList<>(Arrays.asList(2)));
        tree.add(4, new ArrayList<>(Arrays.asList(2)));
        System.out.println(maxTrapValue(tree, values));

        System.exit(0);

        // read from input
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int _n = Integer.parseInt(reader.readLine());
            int[] _values = readValues(_n, reader.readLine());
            List<List<Integer>> _tree = initTree(_n);
            readTree(_tree, reader);

            System.out.println(maxTrapValue(_tree, _values));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long maxTrapValue(List<List<Integer>> tree, int[] values) {
        return Math.max(
                _maxTrapValue(tree, 1, false, values, new boolean[values.length]),
                _maxTrapValue(tree, 1, true, values, new boolean[values.length])
        );
    }

    private static long _maxTrapValue(List<List<Integer>> tree, Integer node,
                                      boolean withTrap, int[] values, boolean[] visited) {
        if (visited[node]) return 0;

        visited[node] = true;
        long v = withTrap ? values[node] : 0;
        List<Integer> children = tree.get(node);
        for (Integer child : children) {
            v += _maxTrapValue(tree, child, !withTrap, values, visited);
        }
        return v;
    }

    private static int[] readValues(int n, String readLine) {
        int[] v = new int[n + 1];
        String[] raw = readLine.split(" ");
        for (int i = 0; i < raw.length; i++) {
            v[i+1] = Integer.parseInt(raw[i]);
        }
        return v;
    }

    private static List<List<Integer>> initTree(int n) throws IOException {
        List<List<Integer>> tree = new ArrayList<>(n + 1);
        tree.add(0, Collections.emptyList());
        for (int i = 1; i <= n; i++) {
            tree.add(1, new ArrayList<>());
        }
        return tree;
    }

    private static void readTree(List<List<Integer>> tree, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] raw = line.split(" ");
            Integer a = Integer.valueOf(raw[0]);
            Integer b = Integer.valueOf(raw[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
    }
}