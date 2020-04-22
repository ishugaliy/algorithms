package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.hackerrank.com/contests/projector-algo-base-8-hw-5-zpun0n6c/challenges/optimal-trap-placement-tree
@SuppressWarnings("all")
public class OptimalTrapPlacementOnTree {

    private static List<List<Integer>> tree;
    private static int[] values;
    private static int[] parents;

    private static Map<Boolean, Long[]> dp = new HashMap<>();

    public static void main(String[] args) {
        // CASE #1: 14
        values = new int[]{0, 4, 5, 6, 4, 5};
        dp.put(true, new Long[values.length]);
        dp.put(false, new Long[values.length]);
        parents = new int[values.length];
        tree = new ArrayList<>();
        tree.add(0, Collections.emptyList());
        tree.add(1, new ArrayList<>(Arrays.asList(2)));
        tree.add(2, new ArrayList<>(Arrays.asList(1, 3, 4)));
        tree.add(3, new ArrayList<>(Arrays.asList(2, 5)));
        tree.add(4, new ArrayList<>(Arrays.asList(2)));
        tree.add(5, new ArrayList<>(Arrays.asList(3)));
        System.out.println(maxTrapValue());

        // CASE #2: 16
        values = new int[]{0, 2, 3, 4, -5, 4, -6, 5, 7};
        dp.put(true, new Long[values.length]);
        dp.put(false, new Long[values.length]);
        parents = new int[values.length];
        tree = new ArrayList<>();
        tree.add(0, Collections.emptyList());
        tree.add(1, new ArrayList<>(Arrays.asList(3)));
        tree.add(2, new ArrayList<>(Arrays.asList(3)));
        tree.add(3, new ArrayList<>(Arrays.asList(1, 2, 4)));
        tree.add(4, new ArrayList<>(Arrays.asList(3, 5, 6)));
        tree.add(5, new ArrayList<>(Arrays.asList(4)));
        tree.add(6, new ArrayList<>(Arrays.asList(4, 7)));
        tree.add(7, new ArrayList<>(Arrays.asList(6, 8)));
        tree.add(8, new ArrayList<>(Arrays.asList(7)));
        System.out.println(maxTrapValue());

        // CASE #3: 10
        values = new int[]{0, 3, 10, 3, 3};
        dp.put(true, new Long[values.length]);
        dp.put(false, new Long[values.length]);
        parents = new int[values.length];
        tree = new ArrayList<>();
        tree.add(0, Collections.emptyList());
        tree.add(1, new ArrayList<>(Arrays.asList(2)));
        tree.add(2, new ArrayList<>(Arrays.asList(1, 3, 4)));
        tree.add(3, new ArrayList<>(Arrays.asList(2)));
        tree.add(4, new ArrayList<>(Arrays.asList(2)));
        System.out.println(maxTrapValue());

        // CASE #4: 9
        values = new int[]{0, 3, 8, 3, 3};
        dp.put(true, new Long[values.length]);
        dp.put(false, new Long[values.length]);
        parents = new int[values.length];
        tree = new ArrayList<>();
        tree.add(0, Collections.emptyList());
        tree.add(1, new ArrayList<>(Arrays.asList(2)));
        tree.add(2, new ArrayList<>(Arrays.asList(1, 3, 4)));
        tree.add(3, new ArrayList<>(Arrays.asList(2)));
        tree.add(4, new ArrayList<>(Arrays.asList(2)));
        System.out.println(maxTrapValue());

        // CASE #5: 132
        values = new int[]{0, 2, -3, 1, 30, 1, 1, 100};
        dp.put(true, new Long[values.length]);
        dp.put(false, new Long[values.length]);
        parents = new int[values.length];
        tree = new ArrayList<>();
        tree.add(0, Collections.emptyList());
        tree.add(1, new ArrayList<>(Arrays.asList(2, 3)));
        tree.add(2, new ArrayList<>(Arrays.asList(1)));
        tree.add(3, new ArrayList<>(Arrays.asList(1, 4)));
        tree.add(4, new ArrayList<>(Arrays.asList(3, 5)));
        tree.add(5, new ArrayList<>(Arrays.asList(4, 6)));
        tree.add(6, new ArrayList<>(Arrays.asList(5, 7)));
        tree.add(7, new ArrayList<>(Arrays.asList(6)));
        System.out.println(maxTrapValue());


        // CASE #6: 0
        values = new int[]{0, -1, -100, -2, -3};
        dp.put(true, new Long[values.length]);
        dp.put(false, new Long[values.length]);
        parents = new int[values.length];
        tree = new ArrayList<>();
        tree.add(0, Collections.emptyList());
        tree.add(1, new ArrayList<>(Arrays.asList(2, 3)));
        tree.add(2, new ArrayList<>(Arrays.asList(1)));
        tree.add(3, new ArrayList<>(Arrays.asList(1, 4)));
        tree.add(4, new ArrayList<>(Arrays.asList(3)));
        System.out.println(maxTrapValue());


        // CASE #7: 2499950000
        values = new int[100_000];
        dp.put(true, new Long[values.length]);
        dp.put(false, new Long[values.length]);
        parents = new int[values.length];
        tree = new ArrayList<>();
        tree.add(0, Collections.emptyList());
        for (int i = 0; i < values.length - 1; i++) {
            values[i] = i;
            tree.add(i, Arrays.asList(i + 1));
        }
        System.out.println(maxTrapValue());


        System.exit(0);

        // read from input
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int _n = Integer.parseInt(reader.readLine());
            values = readValues(_n, reader.readLine());
            tree = initTree(_n);
            readTree(tree, reader);

            dp.put(true, new Long[_n + 1]);
            dp.put(false, new Long[_n + 1]);
            parents = new int[_n + 1];

            System.out.println(maxTrapValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long maxTrapValue() {
        LinkedList<Integer> sorted = topologicalSort();
        while (!sorted.isEmpty()) {
            Integer node = sorted.pollLast();

            long noTrap = 0;
            long withTrap = values[node] >= 0 ? values[node] : 0;

            List<Integer> children = tree.get(node);
            for (Integer child : children) {
                if (child != parents[node]) {
                    noTrap += Math.max(
                            dp.get(true)[child],
                            dp.get(false)[child]
                    );
                    withTrap += dp.get(false)[child];
                }
            }

            dp.get(true)[node] = withTrap;
            dp.get(false)[node] = noTrap;
        }
        return Math.max(
                dp.get(true)[1],
                dp.get(false)[1]
        );
    }

    private static LinkedList<Integer> topologicalSort() {
        LinkedList<Integer> dfs = new LinkedList<>();
        LinkedList<Integer> sort = new LinkedList<>();

        dfs.addLast(1);
        while (!dfs.isEmpty()) {
            Integer node = dfs.pollLast();
            List<Integer> children = tree.get(node);
            for (Integer child : children) {
                if (child != parents[node]) {
                    dfs.addLast(child);
                    parents[child] = node;
                }
            }
            sort.addLast(node);
        }
        return sort;
    }

    private static int[] readValues(int n, String line) {
        int[] v = new int[n + 1];
        String[] raw = line.split(" ");
        for (int i = 1; i <= raw.length; i++) {
            v[i] = Integer.parseInt(raw[i - 1]);
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
