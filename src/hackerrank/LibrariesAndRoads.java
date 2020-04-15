package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.hackerrank.com/contests/projector-algo-base-8-hw-5-zpun0n6c/challenges/libraries-and-roads
@SuppressWarnings("all")
public class LibrariesAndRoads {

    public static void main(String[] args) {
        // CASE #1
        int n = 3; // cities
        int m = 3; // roadsw
        int cl = 2; // cost of library
        int cr = 1; // cost of road
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        tree.computeIfAbsent(1, k -> new HashSet<>()).addAll(Arrays.asList(2, 3));
        tree.computeIfAbsent(2, k -> new HashSet<>()).addAll(Arrays.asList(1, 3));
        tree.computeIfAbsent(3, k -> new HashSet<>()).addAll(Arrays.asList(1, 2));
        boolean[] visited = new boolean[n + 1];

        System.out.println(buildLibrariesAndRoads(tree, cl, cr, new boolean[n + 1]));   // 4


        // CASE #2
        n = 6; // cities
        m = 6; // roads
        cl = 2; // cost of library
        cr = 5; // cost of road
        tree = new HashMap<>();
        tree.computeIfAbsent(1, k -> new HashSet<>()).addAll(Arrays.asList(3, 2));
        tree.computeIfAbsent(2, k -> new HashSet<>()).addAll(Arrays.asList(1, 4, 3));
        tree.computeIfAbsent(3, k -> new HashSet<>()).addAll(Arrays.asList(1, 4, 2));
        tree.computeIfAbsent(4, k -> new HashSet<>()).addAll(Arrays.asList(3, 2));
        tree.computeIfAbsent(5, k -> new HashSet<>()).addAll(Arrays.asList(6));
        tree.computeIfAbsent(6, k -> new HashSet<>()).addAll(Arrays.asList(5));
        visited = new boolean[n + 1];

        System.out.println(buildLibrariesAndRoads(tree, cl, cr, new boolean[n + 1])); // 12

        // Read from Input
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int _q = Integer.parseInt(reader.readLine());
            for (int i = 0; i < _q; i++) {
                String[] raw = reader.readLine().split(" ");
                int _n = Integer.parseInt(raw[0]);
                int _m = Integer.parseInt(raw[1]);
                int _cl = Integer.parseInt(raw[2]);
                int _cr = Integer.parseInt(raw[3]);

                Map<Integer, Set<Integer>> _tree = initTree(_n);
                fillTree(_tree, _m, reader);

                // solution
                System.out.println(buildLibrariesAndRoads(_tree, _cl, _cr, new boolean[_n]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long buildLibrariesAndRoads(Map<Integer, Set<Integer>> tree,
                                              int cl, int cr, boolean[] visited) {
        long minCost = 0;
        for (Integer city : tree.keySet()) {
            if (!visited[city]) {
                minCost += cl + Math.min(cl, cr) * ( dfs(tree, city, visited) - 1 );
            }
        }
        return minCost;
    }

    private static int dfs(Map<Integer, Set<Integer>> tree, Integer city, boolean[] visited) {
        if (visited[city]) return 0;

        int count = 1;
        visited[city] = true;
        for (Integer cc : tree.get(city)) {
            count += dfs(tree, cc, visited);
        }
        return count;
    }

    private static Map<Integer, Set<Integer>> initTree(int n) {
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        while(n > 0) {
            tree.put(n--, new HashSet<>());
        }
        return tree;
    }

    private static void fillTree(Map<Integer, Set<Integer>> tree, int m,
                                 BufferedReader reader) throws IOException {
        for (int k = 0; k < m; k++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
    }
}
