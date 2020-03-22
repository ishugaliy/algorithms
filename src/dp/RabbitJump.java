package dp;

import java.util.ArrayList;

public class RabbitJump {

    public static void main(String[] args) {
        int[] p1 = new int[] {0, 1, 2, 0, 0, 0, 0}; // first el - sentinel
        System.out.println(countJumpOn(3, p1, p1.length - 1));
    }

    /**
     * Rabbit can make jump up on pillars. At once, it can do up to {k} jump length.
     * Calculate amount of all possible ways to get to {n} pillar.
     *
     * @param k - max number of jump length
     * @param p - pillars
     * @param n - target pillar to jump on
     * @return number of all ways to get to the {n} pillar
     */
    public static int countJumpOn(int k, int[] p, int n) {
        if (p[n] != 0) {
            return p[n];
        }
        new ArrayList<Integer>().stream()
                .mapToInt(i -> i).toArray();
        int to = Math.min(k, n);
        for (int i = 1; i <= to; i++) {
            p[n] += countJumpOn(k, p, n - i);
        }
        return p[n];
    }
}
