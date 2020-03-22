package leetcode.contest.weekly._181;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/contest/weekly-contest-181/problems/create-target-array-in-the-given-order/
public class TargetArrayOrder {

    public static void main(String[] args) {
        // [0,4,1,3,2]
        System.out.println(Arrays.toString(createTargetArray(new int[] {0,1,2,3,4}, new int[] {0,1,2,2,1})));
        // [0,1,2,3,4]
        System.out.println(Arrays.toString(createTargetArray(new int[] {1,2,3,4,0}, new int[] {0,1,2,3,0})));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            target.add(index[i], nums[i]);
        }
        return target.stream().mapToInt(i -> i).toArray();
    }
}
