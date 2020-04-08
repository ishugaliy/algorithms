package leetcode.contest.april_2020.week_1;


import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2,2,1}));      // 1
        System.out.println(singleNumber(new int[] {4,1,2,1,2}));  // 4
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> counts = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!counts.remove(nums[i])) {
                counts.add(nums[i]);
            }
        }
        return counts.iterator().next();
    }
}
