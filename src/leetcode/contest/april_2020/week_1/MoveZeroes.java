package leetcode.contest.april_2020.week_1;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr1 = {0,1,0,3,12};
        moveZeroes(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 0};
        moveZeroes(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void moveZeroes(int[] nums) {
        _moveZeroes(nums, 0, 0);
    }

    private static void _moveZeroes(int[] nums, int p1, int p2) {
        while(p1 < nums.length && nums[p1] != 0) { p1++; } // zero pointer
        while(p2 < nums.length && nums[p2] == 0) { p2++; } // non-zero pointer

        if (p1 < nums.length && p2 < nums.length) {
            if (p2 > p1) swap(nums, p1, p2);
            _moveZeroes(nums, p1, p1);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
