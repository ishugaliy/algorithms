package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LastStone {

    public static void main(String[] args) {
        System.out.println(countWins(1, 5, new int[]{1, 3, 4}));                            // 4
        System.out.println(countWins(1, 1, new int[]{1, 3, 4}));                            // 1
        System.out.println(countWins(1, 100, new int[]{1}));                                // 50
        System.out.println(countWins(1, 10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));     // 10
        System.out.println(countWins(1, 8, new int[]{1, 2, 3}));                            // 6
        System.out.println(countWins(1, 8, new int[]{1, 2, 3}));                            // 6
        System.out.println(countWins(1, 100_000, new int[]{2, 3, 11}));                     // 64_286
        System.out.println(countWins(99_999, 100_000, new int[]{1, 2, 3}));                 // 1

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] params = reader.readLine().trim().split(" ");
            int s = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int n = Integer.parseInt(params[2]);
            int[] pulls = Arrays.stream(reader.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            // algorithm
            System.out.println(countWins(m, n, pulls));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countWins(int m, int n, int[] pulls) {
        int wins = 0;
        Map<Integer, Boolean> winsCache = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (canWin(i, pulls, winsCache) && i >= m) wins++;
        }
        return wins;
    }

    private static boolean canWin(int stones, int[] pulls, Map<Integer, Boolean> winsCache) {
        if (winsCache.containsKey(stones)) return winsCache.get(stones);

        boolean canWin = false;
        for (int pull : pulls) {
            int stonesLeft = stones - pull;
            if (canWin || stonesLeft < 0) break;
            if (stonesLeft == 0) {
                canWin = true;
                break;
            }
            canWin = !canWin(stonesLeft, pulls, winsCache);
        }
        winsCache.put(stones, canWin);
        return canWin;
    }
}
