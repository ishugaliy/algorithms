package sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 100, 5};
        int[] arr2 = {1};
        int[] arr3 = {0, 0, 1000000, -1000001};
        int[] arr4 = {103, 865, 7732, 2628, 5481, 1874, 5771, 7095, 5467, 9818};
        int[] arr5 = new int[100_000];
        Random random = new Random();
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = random.nextInt();
        }

        System.out.println("selection sort: " + Arrays.toString(mergeSort(Arrays.copyOf(arr1, arr1.length))));
        System.out.println("selection sort: " + Arrays.toString(mergeSort(Arrays.copyOf(arr2, arr2.length))));
        System.out.println("selection sort: " + Arrays.toString(mergeSort(Arrays.copyOf(arr3, arr3.length))));
        System.out.println("selection sort: " + Arrays.toString(mergeSort(Arrays.copyOf(arr4, arr4.length))));
        long start = System.currentTimeMillis();
        mergeSort(Arrays.copyOf(arr5, arr5.length));
        System.out.println((float) (System.currentTimeMillis() - start) / 1000 + " sec.");
    }
    
    private static int[] mergeSort(int[] arr) {
        return arr;
    }
}
