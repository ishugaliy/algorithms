package datatype;

import java.util.Random;

public final class AlgoUtils {

    private AlgoUtils() { }

    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static int[] generateArray(int size) {
        return generateArray(size, Integer.MAX_VALUE);
    }

    public static int[] generateArray(int size, int bound) {
        Random r = new Random(bound);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(bound);
        }
        return arr;
    }
}
