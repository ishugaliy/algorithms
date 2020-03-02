package sort;

public class CountSort {

    public static void main(String[] args) {
        sort(new int[]{3, 1, 100, 5});
        sort(new int[]{1});
        sort(new int[]{0, 0, 1000000, 1000001});
        sort(new int[]{103, 865, 7732, 2628, 5481, 1874, 5771, 7095, 5467, 9818});
    }

    private static void sort(int[] arr) {
        int[] stats = new int[1000002];
        for (int value : arr) {
            stats[value]++;
        }
        for (int i = 0; i < stats.length; i++) {
            for (int j = 0; j < stats[i]; j++) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
