package leetcode.contest.weekly._181;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/contest/weekly-contest-181/problems/four-divisors/
public class FourDivisors {

    public static void main(String[] args) {
        System.out.println(sumFourDivisors(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            int[] divs = countDivisors(n);
            if (divs.length == 4) {
                for (int d : divs) {
                    sum += d;
                }
            }
        }
        return sum;
    }

    private static int[] countDivisors(int n) {
        List<Integer> div = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (div.size() > 4) {
                div.clear();
                break;
            }
            if (n % i == 0) {
                div.add(i);
                if (n / i != i) {
                    div.add(n / i);
                }
            }
        }
        return div.stream().mapToInt(i -> i).toArray();
    }
}
