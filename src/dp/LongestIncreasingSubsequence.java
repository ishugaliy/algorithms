package dp;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(lis(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));  // 4
        System.out.println(lis(new int[]{10, 9, 2, 5, 3, 4}));           // 3
        System.out.println(lis(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));  // 6
        System.out.println(lis(new int[]{0}));                           // 1
    }

    public static int lis(int[] nums) {
        int[][] m = new int[nums.length + 1][nums.length];
        for (int[] row : m) { Arrays.fill(row, -1); }
        return _lis(nums, -1, 0, m);
    }

    private static int _lis(int[] nums, int prev_idx, int curr_idx, int[][] m) {
        if (nums.length == curr_idx) return 0;
        if (m[curr_idx][prev_idx + 1] > -1 ) return m[curr_idx][prev_idx + 1];

        int use = 0;
        if (prev_idx < 0 || nums[curr_idx] > nums[prev_idx]) {
            use = 1 + _lis(nums, curr_idx, curr_idx + 1, m);
        }
        int unuse = _lis(nums, prev_idx, curr_idx + 1, m);

        m[curr_idx][prev_idx + 1] = Math.max(use, unuse);
        return m[curr_idx][prev_idx + 1];
    }
}
