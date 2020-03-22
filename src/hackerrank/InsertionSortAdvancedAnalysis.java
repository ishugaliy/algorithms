package hackerrank;

import datatype.AlgoUtils;

import java.util.Arrays;

// https://www.hackerrank.com/contests/projector-algo-base-10-hw-3/challenges/insertion-sort/problem
public class InsertionSortAdvancedAnalysis {

    public static void main(String[] args) {
        System.out.println("[4, 3, 2, 1] [6] : " + countShifts(new int[]{4, 3, 2, 1}));
        System.out.println("[1, 1, 1, 2, 2] [0] : " + countShifts(new int[]{1, 1, 1, 2, 2}));
        System.out.println("[2, 1, 3, 1, 2] [4] : " + countShifts(new int[]{2, 1, 3, 1, 2}));

        int[] arr5 = AlgoUtils.generateArray(100_000);
        long start = System.currentTimeMillis();
        countShifts(Arrays.copyOf(arr5, arr5.length));
        System.out.println("exec time: " + (float) (System.currentTimeMillis() - start) / 1000);
    }

    private static long countShifts(int[] arr) {
        return mergeInsertionCount(arr, 0, arr.length - 1);
    }

    private static long mergeInsertionCount(int[] arr, int low, int high) {
        long shifts = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            shifts += mergeInsertionCount(arr, low, mid);
            shifts += mergeInsertionCount(arr, mid + 1, high);
            shifts += merge(arr, low, mid, high);
        }
        return shifts;
    }

    private static long merge(int[] arr, int low, int mid, int high) {
        long shift = 0;

        // Fill tmp arrays
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];
        System.arraycopy(arr, low, left, 0, left.length);
        System.arraycopy(arr, mid + 1, right, 0, right.length);

        // Merge
        int l = 0;
        int r = 0;
        for (int i = low; i <= high; i++) {
            if (l > left.length - 1) {
                while (r < right.length) {
                    arr[i++] = right[r++];
                }
                break;
            }
            if (r > right.length - 1) {
                while (l < left.length) {
                    arr[i++] = left[l++];
                }
                break;
            }

            if (left[l] <= right[r]) {
                arr[i] = left[l++];
            } else {
                arr[i] = right[r++];
                shift += left.length - l;
            }
        }
        return shift;
    }
}
