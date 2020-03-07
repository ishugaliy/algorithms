package sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 100, 5};
        int[] arr2 = {1};
        int[] arr3 = {0, 0, 1000000, -1000001};
        int[] arr4 = {103, 865, 7732, 2628, 5481, 1874, 5771, 7095, 5467, 9818};
        int[] arr5 = new int[1_000];
        Random random = new Random();
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = random.nextInt();
        }

//        sort(arr1);
        System.out.println("selection sort: " + Arrays.toString(arr1));
//        System.out.println("selection sort: " + Arrays.toString(sort(Arrays.copyOf(arr2, arr2.length))));
//        System.out.println("selection sort: " + Arrays.toString(sort(Arrays.copyOf(arr3, arr3.length))));
//        System.out.println("selection sort: " + Arrays.toString(sort(Arrays.copyOf(arr4, arr4.length))));
//        long start = System.currentTimeMillis();
//        sort(Arrays.copyOf(arr5, arr5.length));
//        System.out.println((float) (System.currentTimeMillis() - start) / 1000 + " sec.");
    }
    
    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, mid + 1, right);
        }
    }

//    [3, 1]  [100, 5]
    private static void merge(int[] arr, int l1, int r1, int l2, int r2) {
//        while (l1 <= r1 && arr[l1] < ) {
//            l1++;
//        }
    }
}
