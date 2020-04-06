package leetcode.contest.april_2020;

import java.util.Arrays;

public class MaxProfit {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 7
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));   // 4
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));   // 0
    }

    public static int maxProfit(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }

    // Brute force
    public static int maxProfit_2(int[] arr) {
        int[] cache = new int[]{arr.length};
        Arrays.fill(cache, -1);
        return _maxProfit_2(arr, cache);
    }

    private static int _maxProfit_2(int[] arr, int[] cache) {
        if (arr.length < 1) return 0;
        if (cache[arr.length] != -1) return cache[arr.length];
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[0]) {
                int profit = arr[i] - arr[0]
                        + _maxProfit_2(Arrays.copyOfRange(arr, i + 1, arr.length), cache);
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        maxProfit = Math.max(maxProfit, _maxProfit_2(Arrays.copyOfRange(arr, 1, arr.length), cache));
        cache[arr.length] = maxProfit;
        return maxProfit;
    }
}
