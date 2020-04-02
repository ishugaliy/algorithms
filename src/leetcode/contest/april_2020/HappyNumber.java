package leetcode.contest.april_2020;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isHappy(19)); // true
        System.out.println(sol.isHappy(37)); // false
    }

    static class Solution {

        public boolean isHappy(int n) {
            Set<Integer> cache = new HashSet<>();
            return _isHappy(n, cache);
        }

        private boolean _isHappy(int n, Set<Integer> cache) {
            if (n == 1) return true;
            if (cache.contains(n)) return false;

            String s = String.valueOf(n);
            int squareSum = 0;
            for(int i = 0; i < s.length(); i++) {
                int v = Integer.parseInt(String.valueOf(s.charAt(i)));
                squareSum += v * v;
            }
            cache.add(n);
            return _isHappy(squareSum, cache);
        }
    }
}
