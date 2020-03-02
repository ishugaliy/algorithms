package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerrank.com/contests/projector-algo-base-10-hw-2-zpun0n6c/challenges/garland
public class Garland {

    public static void main(String[] args) {
        int a[][] = {{1, 3, 4}, {2, 3}, {7, 6, 5, 4, 3, 2, 1}, {9}, {8}};
        System.out.println("expected: 9.75 actual: " + findMostRightLampHeight(8, 15));
        System.out.println("expected: 0 actual: " + findMostRightLampHeight(3, 15));
        System.out.println("expected: 446113.344348 actual: " + findMostRightLampHeight(692, 532.81));

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] parts = reader.readLine().split(" ");
            double h = findMostRightLampHeight(Integer.parseInt(parts[0]), Double.parseDouble(parts[1]));
            System.out.println(h);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double findMostRightLampHeight(int n, double a) {
        double lower = 0;
        double upper = a;
        for (int i = 0; i < 60; i++) {
            double pivot = (upper + lower) / 2;
            if (getMinLampHeight(n, a, pivot) >= 0) {
                upper = pivot;
            } else {
                lower = pivot;
            }
        }
        return getLampHeight(a, upper, n);
    }

    private static double getMinLampHeight(int n, double a1, double a2) {
        double min = a2;
        for (int i = 3; i <= n; i++) {
            double h = getLampHeight(a1, a2, i);
            if (h < min) {
                min = h;
            } else {
                return min;
            }
        }
        return min;
    }

    private static double getLampHeight(double a1, double a2, int idx) {
        return (idx - 1) * a2 - (idx - 2) * a1 + sumOfSeq(idx - 1);
    }

    private static long sumOfSeq(double n) {
        int d = 2; int a1 = 0;
        return (long) (n / 2 * (2 * a1 + (n - 1) * d));
    }
}