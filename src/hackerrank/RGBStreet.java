package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.hackerrank.com/contests/projector-algo-base-7-hw-4-xyzc/challenges/rgb-street
public class RGBStreet {

    public static void main(String[] args) {
        System.out.println(countExpenses(new int[][]{{1, 100, 100}, {100, 1, 100}, {100, 100, 1}}));            // 3
        System.out.println(countExpenses(new int[][]{{1, 100, 100}, {100, 100, 100}, {1, 100, 100}}));          // 102
        System.out.println(countExpenses(new int[][]{{26, 40, 83}, {49, 60, 57}, {13, 89, 99}}));               // 96
        System.out.println(countExpenses(new int[][]{{30, 19, 5}, {64, 77, 64}, {15, 19, 97}, {4, 71, 57}, {90, 86, 84}, {93, 32, 91}}));    // 208

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int housesCount = Integer.parseInt(reader.readLine());
            int[][] costs = new int[housesCount][3];
            for (int i = 0; i < housesCount; i++) {
                costs[i] = Arrays
                        .stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            // algorithm
            System.out.println(countExpenses(costs));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * int[][] costs:
     * <p>
     * costs.length - houses count -> h
     * costs[i].length - colors count, always 3 {R,G,B} -> c
     */
    public static int countExpenses(int[][] costs) {
        if (costs.length == 0) return 0;

        int[] expenses = costs[0];
        for (int h = 1; h < costs.length; h++) {
            int[] tmp = new int[3];
            tmp[0] = Math.min(expenses[1], expenses[2]) + costs[h][0];
            tmp[1] = Math.min(expenses[0], expenses[2]) + costs[h][1];
            tmp[2] = Math.min(expenses[0], expenses[1]) + costs[h][2];
            expenses = tmp;
        }
        return findMin(expenses);
    }

    public static int findMin(int[] a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
}
