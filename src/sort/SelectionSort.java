package sort;

import datatype.AlgoUtils;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 100, 5};
        int[] arr2 = {1};
        int[] arr3 = {0, 0, 1000000, -1000001};
        int[] arr4 = {103, 865, 7732, 2628, 5481, 1874, 5771, 7095, 5467, 9818};
        int[] arr5 = AlgoUtils.generateArray(100_000);

        System.out.println("selection sort: " + Arrays.toString(selectionSort(Arrays.copyOf(arr1, arr1.length))));
        System.out.println("selection sort: " + Arrays.toString(selectionSort(Arrays.copyOf(arr2, arr2.length))));
        System.out.println("selection sort: " + Arrays.toString(selectionSort(Arrays.copyOf(arr3, arr3.length))));
        System.out.println("selection sort: " + Arrays.toString(selectionSort(Arrays.copyOf(arr4, arr4.length))));
        long start = System.currentTimeMillis();
        selectionSort(Arrays.copyOf(arr5, arr5.length));
        System.out.println((float) (System.currentTimeMillis() - start) / 1000 + " sec.");
    }
    
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = findMinIdx(arr, i);
            AlgoUtils.swap(arr, i, minIdx);
        }
        return arr;
    }

    private static int findMinIdx(int[] arr, int from) {
        int idx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = from; i < arr.length; i++) {
            if (arr[i] <= min) {
                idx = i;
                min = arr[i];
            }
        }
        return idx;
    }
}
