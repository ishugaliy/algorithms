package recursion;

import datatype.AlgoUtils;

import java.util.Arrays;

public class Combinations {

    public static void main(String[] args) {
        int[] src = {1, 2, 3};
        int k = 3; // length of the combination

        System.out.println("---REPETITION---");
        repetition(src, k, new int[k], 0);
        System.out.println();

        System.out.println("---PERMUTATION---");
        permutation(src, k, new int[k], 0);
        System.out.println();

        System.out.println("---SUBSET---");
        subset(src, k, new int[k], 0);
        System.out.println();

    }

    /**
     * [РАЗМЕЩЕНИЕ C ПОВТОРЕНИЕМ]
     * Print all {k} size combinations with repetition from src numbers
     *
     * @param src - available numbers
     * @param k   - length of the combination
     * @param c   - current combination
     * @param s   - current size of combination, 0 for first call
     */
    public static void repetition(int[] src, int k, int[] c, int s) {
        if (s < k) {
            for (int v : src) {
                c[s] = v;
                repetition(src, k, c, s + 1);
            }
        } else {
            System.out.println(Arrays.toString(c));
        }
    }

    /**
     * [ПЕРЕСТАНОВКА]
     * Print all {k} size combinations with permutation from src numbers
     *
     * @param src - available numbers
     * @param k   - length of the combination
     * @param c   - current combination
     * @param s   - current size of combination, 0 for first call
     */
    public static void permutation(int[] src, int k, int[] c, int s) {
        if (s < k) {
            for (int i = 0; i < src.length; i++) {
                if (!AlgoUtils.contains(c, src[i])) {
                    c[s] = src[i];                     // # CHOOSE
                    permutation(src, k, c, s + 1);  // # EXPLORE
                    c[s] = 0;                          // # UN-CHOOSE
                }
            }
        } else {
            System.out.println(Arrays.toString(c));
        }
    }

    /**
     * [СОЧЕТАНИЕ]
     * Print all {k} size subset from src numbers set
     *
     * @param src   - available numbers
     * @param k     - length of the combination
     * @param res   - current combination
     * @param start - current size of combination, 0 for first call
     */
    // TODO: fix -> broken for k = 2
    public static void subset(int[] src, int k, int[] res, int start) {
        if (start < k) {
            for (int i = start; i < src.length; i++) {
                res[start] = src[i];
                Arrays.stream(res)
                        .filter(v -> v > 0)
                        .forEach(v -> System.out.print(v + " "));
                System.out.println();
                subset(src, k, res, i + 1);
                res[start] = 0;
            }
        }
    }
}
