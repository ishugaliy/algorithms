package leetcode.contest.weekly._181;

// TODO: solve
// https://leetcode.com/contest/weekly-contest-181/problems/check-if-there-is-a-valid-path-in-a-grid/
public class ValidPath {

    public static void main(String[] args) {
        System.out.println(new Solution().hasValidPath(new int[][] {{2,4,3}, {6,5,2}}));
    }

    static class Solution {

        public boolean hasValidPath(int[][] grid) {
            int row = 0;
            int col = 0;
            while (row < grid.length && col < grid[row].length && grid[row][col] > 0) {
                switch (grid[row][col]) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                }
            }
            return false;
        }
    }
}
