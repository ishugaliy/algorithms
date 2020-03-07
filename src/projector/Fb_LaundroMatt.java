package projector;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.facebook.com/hackercup/problem/1611251319125133/
public class Fb_LaundroMatt {

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

    /**
     * Expected results:
     * -----------------
     * Case #1: 1234
     * Case #2: 12
     * Case #3: 5
     * Case #4: 22
     * Case #5: 3003
     */
    public static void main(String[] args) {
        int t = Integer.parseInt(testCases[0]);
        for (int i = 1, j = 1; i <= t && j < testCases.length; i++, j += 2) {

            // Params
            String[] parts = testCases[j].split(" ");
            int l = Integer.parseInt(parts[0]);           // loads
            int n = Integer.parseInt(parts[1]);           // dryers
            int m = Integer.parseInt(parts[2]);           // washing machines
            int d = Integer.parseInt(parts[3]);           // dry time
            int[] w = parseWashingTime(testCases[j + 1]); // machines wash time

            // Wash
            int time = visitLaundry(l, w, d);
            System.out.println(String.format("Case #%d: %d", i, time));
        }
    }

    public static int visitLaundry(int l, int[] w, int d) {
        PriorityQueue<WashMachine> washQueue = Arrays.stream(w)
                .mapToObj(WashMachine::of)
                .collect(Collectors.toCollection(PriorityQueue::new));

        int visitTime = 0;
        while (washQueue.size() > 0) {
            WashMachine wm = washQueue.poll();
            if (l-- > 0) {
                wm.wash(washQueue);
                visitTime = wm.endTime + d;
            }
        }
        return visitTime;
    }

    private static int[] parseWashingTime(String str) {
        return Stream.of(str.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static final class WashMachine implements Comparable<WashMachine> {
        private final int washTime;
        private int endTime;

        private WashMachine(int washTime) {
            this.washTime = washTime;
        }

        public static WashMachine of(int washTime) {
            return new WashMachine(washTime);
        }

        public final void wash(PriorityQueue<WashMachine> queue) {
            endTime += washTime;
            queue.add(this);
        }

        @Override
        public int compareTo(WashMachine other) {
            return Integer.compare(endTime + washTime, other.endTime + other.washTime);
        }
    }
}
