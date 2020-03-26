package leetcode;

// https://leetcode.com/problems/coin-change/
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));                 // 3
        System.out.println(coinChange(new int[]{2}, 3));                        // -1
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));     // 20
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] a = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int minCoins = Integer.MAX_VALUE;
            for (int c : coins) {
                if (c <= i) {
                    minCoins = Math.min(minCoins, a[i - c] + 1);
                }
            }
            a[i] = minCoins;
        }
        return a[amount] > -1 && a[amount] != Integer.MAX_VALUE ? a[amount] : -1;
    }
}
