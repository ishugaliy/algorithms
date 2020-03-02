package knuth;

public class EuclideanAlgorithm {

    public static void main(String[] args) {
        System.out.println("expect: 17 | actual: " + gcd(119, 544));
        System.out.println("expect: 57 | actual: " + gcd(2166, 6099));
    }

    /*
     * Greatest common divisor
     */
    private static int gcd(int m, int n) {
        int r;
        if (n > m) {
            r = m;
            m = n;
            n = r;
        }
        r =  m - (m / n * n);
        if (r == 0) {
            return n;
        }
        m = n;
        n = r;
        return gcd(m, n);
    }
}
