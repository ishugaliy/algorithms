package leetcode.contest.april_2020.week_1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CountingElements {

    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1, 2, 3}));                // 2
        System.out.println(countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7})); // 0
        System.out.println(countElements(new int[]{1, 3, 2, 3, 5, 0}));       // 3
        System.out.println(countElements(new int[]{1, 1, 2, 2}));             // 2
    }

    public static int countElements(int[] arr) {
        int cnt = 0;
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        for (int v : arr) {
            if (set.contains(v + 1)) cnt++;
        }
        return cnt;
    }
}
