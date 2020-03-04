package sort;

import datatype.AlgoUtils;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 100, 5};
        int[] arr2 = {1};
        int[] arr3 = {0, 0, 1000000, -1000001};
        int[] arr4 = {103, 865, 7732, 2628, 5481, 1874, 5771, 7095, 5467, 9818};

        System.out.println(Arrays.toString(sort(Arrays.copyOf(arr1, arr1.length), 0, arr1.length - 1)));
        System.out.println(Arrays.toString(sort(Arrays.copyOf(arr2, arr2.length), 0, arr2.length - 1)));
        System.out.println(Arrays.toString(sort(Arrays.copyOf(arr3, arr3.length), 0, arr3.length - 1)));
        System.out.println(Arrays.toString(sort(Arrays.copyOf(arr4, arr4.length), 0, arr4.length - 1)));
    }

    public static int[] sort(int[] arr, int left, int right) {
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
                    AlgoUtils.swap(arr, i++, j--);
                }
            }
            sort(arr, left, j);
            sort(arr, i, right);
        }
        return arr;
    }
}
