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

        System.out.println(Arrays.toString(sort(Arrays.copyOf(arr1, arr1.length))));
        System.out.println(Arrays.toString(sort(Arrays.copyOf(arr2, arr2.length))));
        System.out.println(Arrays.toString(sort(Arrays.copyOf(arr3, arr3.length))));
        System.out.println(Arrays.toString(sort(Arrays.copyOf(arr4, arr4.length))));

        long start = System.currentTimeMillis();
        sort(Arrays.copyOf(arr5, arr5.length));
        System.out.println((float) (System.currentTimeMillis() - start) / 1000 + " sec.");
    }

    public static int[] sort(int[] arr) {
        return _sort(arr, 0, arr.length - 1);
    }

    private static int[] _sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            int[] left = _sort(arr, low, mid);
            int[] right = _sort(arr, mid + 1, high);
            return merge(left, right);
        }
        return new int[] { arr[low] };
    }

    private static int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
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
            arr[i] = left[l] < right[r] ? left[l++] : right[r++];
        }
        return arr;
    }
}
