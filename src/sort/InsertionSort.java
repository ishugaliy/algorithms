package sort;

import datatype.SimpleAlgoUtils;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 100, 5};
        int[] arr2 = {1};
        int[] arr3 = {0, 0, 1000000, -1000001};
        int[] arr4 = {103, 865, 7732, 2628, 5481, 1874, 5771, 7095, 5467, 9818};
        int[] arr5 = new int[50_000];
        Random random = new Random();
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = random.nextInt();
        }

        System.out.println("insertion sort: " + Arrays.toString(insertionSort(Arrays.copyOf(arr1, arr1.length))));
        System.out.println("insertion sort: " + Arrays.toString(insertionSort(Arrays.copyOf(arr2, arr2.length))));
        System.out.println("insertion sort: " + Arrays.toString(insertionSort(Arrays.copyOf(arr3, arr3.length))));
        System.out.println("insertion sort: " + Arrays.toString(insertionSort(Arrays.copyOf(arr4, arr4.length))));
        long start = System.currentTimeMillis();
        insertionSort(Arrays.copyOf(arr5, arr5.length));
        System.out.println((float) (System.currentTimeMillis() - start) / 1000 + " sec.");

        System.out.println("binary insertion sort: " + Arrays.toString(binaryInsertionSort(Arrays.copyOf(arr1, arr1.length))));
        System.out.println("binary insertion sort: " + Arrays.toString(binaryInsertionSort(Arrays.copyOf(arr2, arr2.length))));
        System.out.println("binary insertion sort: " + Arrays.toString(binaryInsertionSort(Arrays.copyOf(arr3, arr3.length))));
        System.out.println("binary insertion sort: " + Arrays.toString(binaryInsertionSort(Arrays.copyOf(arr4, arr4.length))));
        start = System.currentTimeMillis();
        binaryInsertionSort(Arrays.copyOf(arr5, arr5.length));
        System.out.println((float) (System.currentTimeMillis() - start) / 1000 + " sec.");
    }

    // O(n^2) solution
    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    SimpleAlgoUtils.swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    // O(n log n) solution
    private static int[] binaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int pos = findPosition(arr, arr[i], i); // binary search
            int v = arr[i];
            for (int j = i; j > pos; j--) {
                arr[j] = arr[j - 1];
            }
            arr[pos] = v;
        }
        return arr;
    }

    private static int findPosition(int[] arr, int v, int to) {
        int lower = -1;
        int upper = to + 1;
        while (upper - lower > 1) {
            int p = (upper + lower) / 2;
            if (arr[p] >= arr[to]) {
                upper = p;
            } else {
                lower = p;
            }
        }
        return upper;
    }
}
