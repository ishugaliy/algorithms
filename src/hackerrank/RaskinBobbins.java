package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RaskinBobbins {

    public static void main(String[] args) {
        // sorted {1,2,3,4,5}
        System.out.print("expected: 1 4 actual: ");
        findOptimalFlavours(4, new int[]{1, 4, 5, 3, 2});
        // sorted {2,2,3,4}
        System.out.print("expected: 1 2 actual: ");
        findOptimalFlavours(4, new int[]{2, 2, 4, 3});

//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            int numOfTrips = Integer.parseInt(reader.readLine());
//            for (int i = 1; i <= numOfTrips; i++) {
//                int m = Integer.parseInt(reader.readLine());
//                int numOfFlavours = Integer.parseInt(reader.readLine());
//                int[] flavours = parseFlavours(reader.readLine());
//
//                // algorithm
//                findOptimalFlavours(m, flavours);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    private static void findOptimalFlavours(int m, int[] f) {
        Map<Integer, Integer> diffs = new HashMap<>();
        for (int i = 0; i < f.length; i++) {
            int diff = m - f[i];
            if (diffs.containsKey(diff)) {
                System.out.println(diffs.get(diff) + " " + (i + 1));
            } else {
                diffs.putIfAbsent(f[i], i + 1);
            }
        }
    }

//    public static void findOptimalFlavours(int m, int[] n) {
//        // O(n log n)
//        int[] sn = Arrays.stream(n)
//                .sorted()
//                .toArray();
//
//        // O(n)
//        int snLeft = 0;
//        int snRight = sn.length - 1;
//        while (sn[snLeft] + sn[snRight] != m) {
//            if (sn[snLeft] + sn[snRight] > m) {
//                snRight--;
//            } else {
//                snLeft++;
//            }
//        }
//
//        //  O(n) - map founded idx in sorted arr with index of source arr
//        int nLeft = -1;
//        int nRight = -1;
//        for (int i = 0; i < n.length; i++) {
//            if (n[i] == sn[snLeft] && nLeft == -1) {
//                nLeft = i + 1;
//            } else {
//                if (n[i] == sn[snRight] && nRight == -1) {
//                    nRight = i + 1;
//                }
//            }
//        }
//        int[] result = IntStream.of(nLeft, nRight)
//                .sorted()
//                .toArray();
//        System.out.println(result[0] + " " + result[1]);
//    }

    private static int[] parseFlavours(String str) {
        return Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
