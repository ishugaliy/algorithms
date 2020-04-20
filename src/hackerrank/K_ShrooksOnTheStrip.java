package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.hackerrank.com/contests/projector-algo-base-8-hw-5-zpun0n6c/challenges/k-shrooks-on-the-strip
public class K_ShrooksOnTheStrip {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(numbOfPositions(1, 6)); // 20
        System.out.println(numbOfPositions(2, 6)); // 12
        System.out.println(numbOfPositions(1, 3)); // 4
        System.out.println(numbOfPositions(1, 2)); // 2
        System.out.println(numbOfPositions(0, 3)); // 7
        System.out.println(numbOfPositions(10, 5));  // 5
        System.out.println(numbOfPositions(1, 20));  // 17710
        System.out.println(numbOfPositions(3, 100)); // 59765849
        System.out.println(numbOfPositions(1000, 1_000_000)); // 608983926

        System.exit(0);

        // read from input
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] raw = reader.readLine().split(" ");
            int K = Integer.parseInt(raw[0]);
            int W = Integer.parseInt(raw[1]);

            System.out.println(numbOfPositions(K, W));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long numbOfPositions(int k, int w) {
        int[] dp = new int[w + 1];
        int shrookSize = k + 1;

        for (int i = 1; i <= w; i++) {
            dp[i] = 1 + dp[i - 1];
            if (i > shrookSize) {
                dp[i] = (dp[i] + dp[i - shrookSize]) % MOD;
            }
        }
        return dp[dp.length - 1];
    }

    public static long numbOfPositions_v2(int k, int w) {
        // since shrook by itself takes 1 cell
        int shrookSize = k + 1;

        // store prefix sum for each shrook
        double shrooksCount = Math.ceil((double) w / shrookSize);

        int[] dp = new int[w + 1];

        // init dp for first shrook
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
        }
        System.out.println(Arrays.toString(dp));

        for (int i = 2; i <= shrooksCount; i++) {
            int shift = shrookSize * (i - 1);
            for (int j = 1; j < dp.length - shift; j++) {
                dp[j] = (dp[j - 1] + dp[j]) % MOD;
            }
            dp[dp.length - 1] += dp[dp.length - shift - 1];
            dp[dp.length - 1] %= MOD;

            System.out.println(Arrays.toString(dp));
        }
        return dp[dp.length - 1];
    }
}
