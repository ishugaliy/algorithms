package hackerrank;

import datatype.AlgoUtils;

import java.util.Arrays;
import java.util.Random;

// https://www.hackerrank.com/contests/projector-algo-base-10-hw-3/challenges/insertion-sort/problem
public class InsertionSortAdvancedAnalysis {

    public static void main(String[] args) {
        int[] arr5 = new int[100_000];
        Random random = new Random();
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = random.nextInt(10_000_000);
        }
        long start = System.currentTimeMillis();
        long actual = countShifts(Arrays.copyOf(arr5, arr5.length));
        System.out.println("smart: " + (float) (System.currentTimeMillis() - start) / 1000);

        start = System.currentTimeMillis();
        long expected = expectedCountShifts(Arrays.copyOf(arr5, arr5.length));
        System.out.println("liner: " + (float) (System.currentTimeMillis() - start) / 1000);

        if (actual != expected) {
            System.out.println(actual + " != " + expected);
        }

        System.out.println("[4, 3, 2, 1]    [6] : " + countShifts(new int[]{4, 3, 2, 1}));
        System.out.println("[1, 1, 1, 2, 2] [0] : " + countShifts(new int[]{1, 1, 1, 2, 2}));
        System.out.println("[2, 1, 3, 1, 2] [4] : " + countShifts(new int[]{2, 1, 3, 1, 2}));
    }

    private static long expectedCountShifts(int[] arr) {
        long shifts = 0;
        for (int i = 1; i < arr.length; i++) {
            int pos = findPosition(arr, arr[i], i); // binary search
            shifts += i - pos;
//            int tmp = arr[i];
//            for (int j = i; j > pos; j--) {
//                arr[j] = arr[j - 1];
//            }
//            arr[pos] = tmp;
            shiftArr(arr, i, pos);
        }
        return shifts;
    }

    private static long countShifts(int[] arr) {
        long shifts = 0;
        for (int i = 1; i < arr.length; i++) {
            int pos = findPosition(arr, arr[i], i); // binary search
            shifts += i - pos;
            shiftArr(arr, i, pos);
        }
        return shifts;
    }

    private static int findPosition(int[] arr, int v, int to) {
        int lower = -1;
        int upper = to;
        while (upper - lower > 1) {
            int p = (upper + lower) / 2;
            if (arr[p] > v) {
                upper = p;
            } else {
                lower = p;
            }
        }
        return upper;
    }

    private static void shiftArr(int[] arr, int from, int to) {
        if (from != to) {
            int tmp = arr[from];
            System.arraycopy(arr, to, arr, to + 1, from - to);
            arr[to] = tmp;
        }
    }
}
