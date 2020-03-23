package dp;

public class RabbitJump {

    public static void main(String[] args) {
        System.out.println("jump on                  : "    // 8
                + countJumpOn(2, new int[]{0, 1, 2, 0, 0, 0, 0}, 5));

        System.out.println("jump in                  : "    // 3
                + countJumpIn(4, new int[]{0, 1, 1, 0, 0, 0, 0, 0, 0}, 8));

        System.out.println("jump on (wolves)         : "    // 2
                + countJumpOnWithWolves(2, new int[]{0, 1, 2, 0, 0, 0, 0}, new int[]{0, 0, 1, 0, 0, 0, 0}, 5));

        System.out.println("jump on (frogs)          : "    // 12
                + countJumpOnWithFrogs(2, new int[]{0, 1, 1, 0, 0, 0, 0, 0, 0}, new int[] {0, 1, 1, 0, 0, 1, 10, 1, 0}, 6));
    }

    /**
     * There are {n} pillars and white rabbit. Rabbit can jump-on from 1 to K pillars.
     * Calculate amount of all possible ways to get to last pillar.
     *
     * @param k - jump on length from 1 to k
     * @param p - pillars
     * @param n - target pillar to jump on
     * @return number of all ways to get to the last pillar
     */
    public static int countJumpOn(int k, int[] p, int n) {
        if (p[n] != 0) return p[n];
        int to = Math.min(k, n);
        for (int i = 1; i <= to; i++) {
            p[n] += countJumpOn(k, p, n - i);
        }
        return p[n];
    }

    /**
     * There are {n} pillars and white rabbit. Rabbit can jump-in from 2 to K pillars.
     * Calculate amount of all possible ways to get to last pillar.
     *
     * @param k - jump on length from 2 to k
     * @param p - pillars
     * @param n - target pillar to jump on
     * @return number of all ways to get to the last pillar
     */
    public static int countJumpIn(int k, int[] p, int n) {
        if (p[n] != 0) return p[n];
        int to = Math.min(k, n);
        for (int i = 2; i <= to; i++) {
            if (n % i == 0) {
                p[n] += countJumpIn(k, p, n / i);
            }
        }
        return p[n];
    }

    /**
     * There are {n} pillars and white rabbit. Rabbit can jump-on from 1 to K pillars.
     * There may be a wolfe sitting on a pillar.
     * Calculate amount of all possible ways to get to last pillar, avoiding pillars with wolves.
     *
     * @param k - jump on length from 1 to k
     * @param p - pillars
     * @param w - wolves positions. Values: 0 - no wolfe, 1 - there is a wolfe
     * @param n - target pillar to jump on
     * @return number of all ways to get to the last pillar
     */
    public static int countJumpOnWithWolves(int k, int[] p, int[] w, int n) {
        if (w[n] == 1) return 0; // wolfe here, 0 ways to get here.
        if (p[n] > 0) return p[n];
        int to = Math.min(k, n);
        for (int i = 1; i <= to; i++) {
            p[n] += countJumpOnWithWolves(k, p, w,n - i);
        }
        return p[n];
    }

    /**
     * There are {n} pillars and white rabbit. Rabbit can jump-on from 1 to K pillars.
     * There is a frog sitting on each pillar that give a reward to a rabbit for jumping on its pillar.
     * Calculate maximum amount of money white rabbit can receive to get to the last pillar.
     *
     * @param k - jump on length from 1 to k
     * @param p - pillars
     * @param f - frogs reward
     * @param n - target pillar to jump on
     * @return number of all ways to get to the last pillar
     */
    public static int countJumpOnWithFrogs(int k, int[] p, int[] f, int n) {
        if (p[n] > 0) return p[n];
        int to = Math.min(k, n);
        for (int i = 1; i <= to; i++) {
            int v = countJumpOnWithFrogs(k, p, f,n - i);
            if (v > p[n]) {
                p[n] = v;
            }
        }
        p[n] += f[n];
        return p[n];
    }
}
