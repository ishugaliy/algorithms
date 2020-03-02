package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerrank.com/contests/projector-algo-base-10-hw-2-zpun0n6c/challenges/1-10-100-1000-1
public class N_1_10_100_1000 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= count; i++) {
                //algorithm
                findDigit(Integer.parseInt(reader.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findDigit(int k) {
        int lower = 0;
        int upper = 100_000;
        while (upper - lower > 1) {
            int pivot = (upper + lower) / 2;
            if (sumOfSequence(pivot) >= k) {
                upper = pivot;
            } else {
                lower = pivot;
            }
        }
        System.out.println(k - sumOfSequence(lower) == 1 ? 1 : 0);
    }

    private static long sumOfSequence(double n) {
        return (long) (n / 2 * (n - 1));
    }
}
