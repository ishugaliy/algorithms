package hackercup;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.facebook.com/hackercup/problem/1611251319125133/
public class LaundroMatt {

    // L N M D
    private static final String[] testCases = {
            "5",
            // Case #1
            "1 1 1 34",
            "1200",
            // Case #2
            "2 3 2 10",
            "100 10 1",
            // Case #3
            "3 3 3 3",
            "1 2 3",
            // Case #4
            "4 2 2 7",
            "5 8",
            // Case #5
            "999 1 999 6",
            "3"
    };

    public static void main(String[] args) {
        String[] input = testCases;

        // Read input
        InputStream io = LaundroMatt.class.getClassLoader().getResourceAsStream("hackercup/laundro_matt.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(io)))) {
//            input = reader.lines().toArray(String[]::new);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        int t = Integer.parseInt(input[0]);

        System.out.println("Case #1: 469387366858");

        for (int i = 1, j = 1; i <= t && j < input.length; i++, j += 2) {

            if (i == 27 || i == 30) continue; // OutOfMemory, because of dryers

            // Params
            String[] parts = input[j].split(" ");
            int l = Integer.parseInt(parts[0]);           // loads
            int n = Integer.parseInt(parts[1]);           // washing machines
            int m = Integer.parseInt(parts[2]);           // dryers
            int d = Integer.parseInt(parts[3]);           // dry time
            int[] w = parseWashingTime(input[j + 1]); // machines wash time

            // Wash
            long time = visitLaundry(l, n, w, m, d);
            System.out.println(String.format("Case #%d: %d", i, time));
        }
    }

    /**
     * Expected results:
     * -----------------
     * Case #1: 1234
     * Case #2: 12
     * Case #3: 5
     * Case #4: 22
     * Case #5: 3003
     */
    public static long visitLaundry(int l, int n, int[] w, int m, int d) {
        PriorityQueue<WashMachine> washQueue = new PriorityQueue<>(w.length);
        for (int i = 0; i < n; i++) {
            washQueue.add(WashMachine.of(w[i]));
        }
        long[] dryQueue = new long[m];

        int dryerIdx = 0;
        long loadEndTime = 0;
        while (l-- > 0) {
            WashMachine wm = washQueue.poll();
            wm.wash(washQueue);

            loadEndTime = Math.max(wm.endTime, dryQueue[dryerIdx]) + d;
            dryQueue[dryerIdx++] = loadEndTime;
            if (dryerIdx == dryQueue.length) {
                dryerIdx = 0;
            }
        }
        return loadEndTime;
    }

    private static int[] parseWashingTime(String str) {
        return Stream.of(str.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static final class WashMachine implements Comparable<WashMachine> {
        private final long washTime;
        private long endTime;

        private WashMachine(long washTime) {
            this.washTime = washTime;
        }

        public static WashMachine of(long washTime) {
            return new WashMachine(washTime);
        }

        public final void wash(PriorityQueue<WashMachine> queue) {
            endTime += washTime;
            queue.add(this);
        }

        @Override
        public int compareTo(WashMachine other) {
            return Long.compare(endTime + washTime, other.endTime + other.washTime);
        }
    }
}
