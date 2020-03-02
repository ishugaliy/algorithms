package hackerrank;

import projector.NoTwoSlash;

import java.util.concurrent.CompletableFuture;

//https://www.hackerrank.com/contests/projector-algo-base-10-hw-1/challenges/sherlock-and-squares
public class SherlockAndSquares {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 1_000_0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j += i) {
                squares(32, 128);
            }
        }
        System.out.println(System.currentTimeMillis() - start);

//
//        System.out.println("expected: 3 actual: " + squares(24, 49));
//        System.out.println("expected: 3 actual: " + squares(25, 49));
//        System.out.println("expected: 2 actual: " + squares(25, 48));
//        System.out.println("expected: 0 actual: " + squares(17, 24));
//        System.out.println("expected: 2 actual: " + squares(3, 9));
    }

    public static int squares(int a, int b) {
        return (int) Math.sqrt(b) - (int) (Math.sqrt(a) - 0.00001);
    }
}
