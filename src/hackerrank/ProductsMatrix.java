package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.hackerrank.com/contests/projector-algo-base-7-hw-4-xyzc/challenges/products-matrix
public class ProductsMatrix {

    public static void main(String[] args) {
        productMatrix(5, 12);
//        System.out.println(productMatrix(3, 7));            // 6
//        System.out.println(productMatrix(3, 8));            // 6
//        System.out.println(productMatrix(2, 4));            // 4
//        System.out.println(productMatrix(4, 4));            // 3
//        System.out.println(productMatrix(1, 1));            // 1
//        System.out.println(productMatrix(100_000, 99_756)); // 27676
//        System.out.println(productMatrix(10_000, 756));     // 364

//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            int[] params = Arrays.stream(reader.readLine().split(" "))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//
//            // algorithm
//            System.out.println(productMatrix(params[0], params[1]));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static int productMatrix(int dim, int k) {
        if (k == 0 || dim == 0) return 0;

        for (int level = 0; ; level++) {
//            if (k % dim == 0) {
//                System.out.println();
//            }
            System.out.print(level + 1 + " ");
            if (level < dim && --k == 0) {
                return level + 1;
            }
            for (int col = 0; col < level; col++) {
                int row = level - col;
                System.out.print(((row + 1) * (col + 1)) + " ");
                if (row < dim && col < dim && --k == 0) {
                    return (row + 1) * (col + 1);
                }
            }
            System.out.println();
        }
    }


//    public static int productMatrix(int dim, int k) {
//        if (k == 0 || dim == 0) return 0;
//
////        final int dim = 3;
////        final int k = 7;
//
//
////        int operCount = 0;
////        int i = 1;
////        int j = 1;
//
////        while(true) {
//        for (int row = 1 ;; row++) {
////                System.out.println("Level " + row);
//
////                System.out.println(i + ":" + row);
////                if(row < dim ++operCount == k) {
////                    System.out.println("FOUND K = " + i * row);
////                    return i * row;
////                }
//            if (row <= dim && --k == 0) {
//                System.out.println("FOUND K = " + row);
//                return row;
//            }
//            for (int col = 1 ; col < row; col++) {
//                if ((row - col + 1) <= dim && col <= dim && --k == 0) {
//                    System.out.println("FOUND K = " + (row - col + 1) * col);
//                    return (row - col + 1) * col;
//                }
//            }
//        }
//    }
}
