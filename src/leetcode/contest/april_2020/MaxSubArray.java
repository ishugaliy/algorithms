package leetcode.contest.april_2020;

// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(maxSubArray(new int[]{-2, -1}));                        // -1
        System.out.println(maxSubArray(new int[]{1, 2, -1}));                      // 3
    }

    public static int maxSubArray(int[] nums) {
        return _maxSubArray(nums, 0, nums.length - 1);
    }

    private static int _maxSubArray(int[] nums, int left, int right) {
        if (right != left) {
            int mid = (left + right) / 2;
            return Math.max(
                    Math.max(_maxSubArray(nums, left, mid), _maxSubArray(nums,mid + 1, right)),
                    maxCrossingSum(nums, left, mid, right)
            );
        }
        return nums[left];
    }

    private static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int i = mid, j = mid + 1;
        int sum = 0;

        int leftMax = Integer.MIN_VALUE;
        while (i >= left) {
            sum += nums[i--];
            if (sum > leftMax) leftMax = sum;
        }

        sum = 0;
        int rightMax = 0;
        while (j <= right) {
            sum += nums[j++];
            if (sum > rightMax) rightMax = sum;
        }

        return leftMax + rightMax;
    }
}
