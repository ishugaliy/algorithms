package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/contests/projector-algo-base-10-hw-3/challenges/closest-numbers
public class ClosestNumbers {

    public static void main(String[] args) {
        System.out.println("expected: [1, 2, 2, 3, 3, 4, 4, 5]");
        System.out.println("  actual: " + Arrays.toString(findClosestPairs(new int[]{5, 2, 3, 4, 1}).toArray()));

        System.out.println("expected: [63, 71]");
        System.out.println("  actual: " + Arrays.toString(findClosestPairs(new int[]{-5, 15, 25, 71, 63}).toArray()));

        System.out.println("expected: [-20, 30]");
        System.out.println("  actual: "
                + Arrays.toString(
                findClosestPairs(new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854})
                        .toArray()));

        System.out.println("expected: [-520, -470, -20, 30]");
        System.out.println("  actual: "
                + Arrays.toString(
                findClosestPairs(new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470})
                        .toArray()
        ));

        System.out.println("expected: [2, 3, 3, 4, 4, 5]");
        System.out.println("  actual: " + Arrays.toString(findClosestPairs(new int[]{5, 4, 3, 2}).toArray()));
    }

    private static List<Integer> findClosestPairs(int[] arr) {
        List<Integer> pairs = new ArrayList<>();
        int[] sorted = qs(arr, 0, arr.length - 1);
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        // find the most closes distance (min)
        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i + 1] - sorted[i] < min) {
                min = sorted[i + 1] - sorted[i];
                minIdx = i;
            }
        }
        // filter all closest pairs equal to distance (min)
        for (int i = minIdx; i < sorted.length - 1; i++) {
            if (sorted[i + 1] - sorted[i] == min) {
                pairs.add(sorted[i]);
                pairs.add(sorted[i + 1]);
            }
        }
        return pairs;
    }

    public static int[] qs(int[] arr, int left, int right) {
        if (left < right) {
            int i = left, j = right;
            int pivot = arr[left + (right - left) / 2];
            while (i <= j) {
                while (arr[i] < pivot) {
                    i++;
                }
                while (arr[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    swap(arr, i++, j--);
                }
            }
            qs(arr, left, j);
            qs(arr, i, right);
        }
        return arr;
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
