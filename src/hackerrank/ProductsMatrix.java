package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.hackerrank.com/contests/projector-algo-base-7-hw-4-xyzc/challenges/products-matrix
public class ProductsMatrix {

    public static void main(String[] args) {
        System.out.println(productMatrix(5, 9));                       // 5
        System.out.println(productMatrix(3, 7));                       // 6
        System.out.println(productMatrix(3, 8));                       // 6
        System.out.println(productMatrix(2, 4));                       // 4
        System.out.println(productMatrix(4, 4));                       // 3
        System.out.println(productMatrix(1, 1));                       // 1
        System.out.println(productMatrix(10_000, 756));                // 147
        System.out.println(productMatrix(100_000, 99_756));            // 10585

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] params = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            // algorithm
            System.out.println(productMatrix(params[0], params[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long productMatrix(int n, int k) {
        long bad = 0;
        long good = Math.max(n * n + 1, 1000 * 1000000);
        while (good - bad > 1) {
            long m = (good + bad) / 2;
            if (numbersBefore(m, n) >= k)
                good = m;
            else
                bad = m;
        }
        return good;
    }

    private static long numbersBefore(long value, int n) {
        long nums = 0;
        for (long i = 1; i <= n; i++) {
            nums += i * n <= value ? n : value / i;
        }
        return nums + 1;
    }
}
