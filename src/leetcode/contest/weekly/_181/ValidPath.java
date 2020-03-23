package leetcode.contest.weekly._181;

import java.util.*;

// TODO: solve
// https://leetcode.com/contest/weekly-contest-181/problems/check-if-there-is-a-valid-path-in-a-grid/
public class ValidPath {

    public static void main(String[] args) {
        System.out.println(new Solution().hasValidPath(new int[][] {{2,4,3}, {6,5,2}}));                         // true
        System.out.println(new Solution().hasValidPath(new int[][] {{1,2,1}, {1,2,1}}));                         // false
        System.out.println(new Solution().hasValidPath(new int[][] {{1,1,2}}));                                  // false
        System.out.println(new Solution().hasValidPath(new int[][] {{1,1,1,1,1,1,3}}));                          // true
        System.out.println(new Solution().hasValidPath(new int[][] {{2},{2},{2},{2},{2},{2},{2},{6}}));          // true
    }

    static class Solution {

        public boolean hasValidPath(int[][] grid) {
            return false;
        }
    }
}
