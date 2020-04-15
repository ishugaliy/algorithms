package hackerrank;

// https://www.hackerrank.com/contests/projector-algo-base-8-hw-5-zpun0n6c/challenges/k-shrooks-on-the-strip
public class K_ShrooksOnTheStrip {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {

        }
        System.out.println((float) (System.currentTimeMillis() - start) / 1000);


        System.out.println(numbOfPositions(1, 3));   // 4
        System.out.println(numbOfPositions(1, 2));   // 2
        System.out.println(numbOfPositions(0, 3));   // 7
        System.out.println(numbOfPositions(10, 5));  // 5
        System.out.println(numbOfPositions(1, 20));  // 17710
        System.out.println(numbOfPositions(3, 100)); // 59765849
    }


    // Brute force
    public static int numbOfPositions(int k, int w) {
        int cnt = 0;
        for (int i = 0; i <= k; i++) {
            cnt++;
            for (int j = i + k + 1; j <= w; j += k + 1) {
                cnt++;
            }
        }
        return cnt;
    }
}
