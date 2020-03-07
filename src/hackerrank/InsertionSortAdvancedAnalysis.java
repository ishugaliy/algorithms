package hackerrank;

import datatype.AlgoUtils;
import sort.QuickSort;

import java.util.*;
import java.util.stream.Collectors;

// https://www.hackerrank.com/contests/projector-algo-base-10-hw-3/challenges/insertion-sort/problem
public class InsertionSortAdvancedAnalysis {

    public static void main(String[] args) {
        int[] arr5 = new int[100_000];
        Random random = new Random();
        for (int i = 0; i < arr5.length; i++) {
            int v = random.nextInt(10_000_000);
            if (v == 0)  v = 1;
            arr5[i] = v;
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
            shiftArr(arr, i, pos);
        }
        return shifts;
    }

    private static long countShifts(int[] arr) {
        long shifts = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    shifts++;
                }
            }
        }
        // count all values
//        int[] vCount = new int[10_000_000];
//        for (int i = 0; i < arr.length; i++) {
//            vCount[arr[i]]++;
//        }
//
//        // find index for all values
//        int[] vIdxCount = new int[10_000_000];
//        vIdxCount[0] = vCount[0];
//        for (int i = 1; i < vCount.length; i++) {
//            vIdxCount[i] = vCount[i] + vIdxCount[i - 1];
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            shifts += Math.abs(i - vIdxCount[arr[i]]) - 1;
//            vIdxCount[arr[i]]--;
//        }
        return shifts;

//        return mergeSort(arr, 0,0, arr.length - 1);
//        return 0;
//        long shift = 0;
//        int[] sorted = Arrays.copyOf(arr, arr.length);
//        QuickSort.sort(sorted, 0, arr.length - 1);
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j < sorted.length; j++) {
//                if (sorted[j] != -1 && arr[i] == sorted[j]) {
//                    shift += j - i;
//                    sorted[j] = -1;
//                    break;
//                }
//            }
//        }


//        return _countShifts(arr, 0, 0, arr.length - 1);
    }

    private static int findPosition2(int[] arr, int v, int to) {
        int lower = -1;
        int upper = to;
        while (upper - lower > 1) {
            int p = (upper + lower) / 2;
            if (arr[p] >= v) {
                upper = p;
            } else {
                lower = p;
            }
        }
        return upper;
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

    static long merge(int arr[], long shift, int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;

        /* create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1+ j];

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = l; // Initial index of merged subarray
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            shift++;
            k++;
        }

    /* Copy the remaining elements of L[], if there
       are any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
        return shift;
    }

    /* l is for left index and r is right index of the
       sub-array of arr to be sorted */
    static long mergeSort(int arr[], long shift, int l, int r)
    {
        if (l < r)
        {
            // Same as (l+r)/2, but avoids overflow for
            // large l and h
            int m = l+(r-l)/2;

            // Sort first and second halves
            mergeSort(arr, shift, l, m);
            mergeSort(arr, shift,m+1, r);

            shift += merge(arr, shift, l, m, r);
        }
        return shift;
    }

}
