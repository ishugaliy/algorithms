package dp;

public class FibonacciNumbers {

    public static void main(String[] args) {
        System.out.println(fib(3, new long[4])); // 3
        System.out.println(fib(4, new long[5])); // 5
        System.out.println(fib(5, new long[6])); // 8

        long start = System.currentTimeMillis();
        System.out.println(fib(100, new long[100_001]));
        System.out.println((float) (System.currentTimeMillis() - start) / 1000 + " sec.");
    }

    public static long fib(int n, long[] c) {
        if (c[n] > 0) return c[n];
        if (n <= 2) {
            c[n] = n;
            return n;
        }
        c[n] = fib(n - 1, c) + fib(n - 2, c);
        return c[n];
    }
}
