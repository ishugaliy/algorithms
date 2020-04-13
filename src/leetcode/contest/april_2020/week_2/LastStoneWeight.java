package leetcode.contest.april_2020.week_2;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("all")
public class LastStoneWeight {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeight(new int[]{2, 2}));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> sortedStones = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            sortedStones.add(stone);
        }
        while (sortedStones.size() > 1) {
            int s = Math.abs(sortedStones.poll() - sortedStones.poll());
            if (s > 0) sortedStones.add(s);
        }
        return sortedStones.size() > 0 ? sortedStones.poll() : 0;
    }
}
