package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryStrings {

    private static int operCount = 0;

    public static void main(String[] args) {
        operCount = 0;
        System.out.println(countStrings(3, 1, new String[]{"1", "00", "100"}));     // 2
        System.out.println("oper: " + operCount);

        operCount = 0;
        System.out.println(countStrings(2, 4, new String[]{"00", "110", "101"}));   // 2
        System.out.println("oper: " + operCount);

        operCount = 0;
        System.out.println(countStrings(500, 500,                                   // 20
                new String[]{
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010",
                        "10101010101010101010101010101010101010101010101010"}
        ));
        System.out.println("oper: " + operCount);


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] raw = reader.readLine().split(" ");
            String[] strings = new String[Integer.parseInt(raw[0])];
            int zeroes = Integer.parseInt(raw[1]);
            int ones = Integer.parseInt(raw[2]);
            for (int i = 0; i < strings.length; i++) {
                strings[i] = reader.readLine();
            }

            // algorithm
            System.out.println(countStrings(zeroes, ones, strings));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countStrings(int zeros, int ones, String[] strings) {
        return _countStrings(zeros, ones, strings, new HashMap<>(strings.length));
    }

    private static int _countStrings(int zeros, int ones, String[] strings, Map<String, Integer[]> cache) {
        if (strings.length == 0 || (zeros == 0 && ones == 0)) return 0;

        Integer[] stats = cache.get(strings[0]);
        if (stats == null) {
            char[] str = strings[0].toCharArray();
            Arrays.sort(str);
            final int pos = findPosition(str, '1');
            final int strOnes = str.length - pos;
            final int strZeros = str.length - strOnes;
            stats = new Integer[]{strZeros, strOnes};
            cache.put(strings[0], stats);
        }
        final int deltaZeros = zeros - stats[0];
        final int deltaOnes = ones - stats[1];
        String[] restStrings = Arrays.copyOfRange(strings, 1, strings.length);
        if (deltaOnes >= 0 && deltaZeros >= 0) {
            return Math.max(
                    _countStrings(zeros, ones, restStrings, cache),
                    _countStrings(deltaZeros, deltaOnes, restStrings, cache) + 1
            );
        } else {
            return _countStrings(zeros, ones, restStrings, cache);
        }
    }

    private static int findPosition(char[] c, char key) {
        int low = -1;
        int high = c.length;
        while (high - low > 1) {
            int mid = (high + low) / 2;
            if (c[mid] >= key) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }
}
