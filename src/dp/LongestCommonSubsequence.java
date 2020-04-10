package dp;

// https://leetcode.com/problems/longest-common-subsequence/
@SuppressWarnings("all")
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println("lcs: " + lcsLength("abcde", "ace"));       // 3
        System.out.println("lcs: " + lcsLength("abc", "abc"));         // 3
        System.out.println("lcs: " + lcsLength("abc", "def"));         // 0

        System.out.println("lcs_fast: " + lcsLength("abcde", "ace"));  // 3
        System.out.println("lcs_fast: " + lcsLength("abc", "abc"));    // 3
        System.out.println("lcs_fast: " + lcsLength("abc", "def"));    // 0

        System.out.println("lcs_str: " + lcsLength("abcde", "ace"));   // ace
        System.out.println("lcs_str: " + lcsLength("abc", "abc"));     // abc
        System.out.println("lcs_str: " + lcsLength("abc", "def"));     // def
    }

    // Output: lcs size
    public static int lcsLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1)
                        ? dp[i-1][j-1] + 1
                        : Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    // Output: lcs size.
    // There is no need to create and store whole matrix dp
    // we need only last row in the martix to calculate next one.
    public static int lcsLength_2(String s1, String s2) {
        int[] prev = new int[s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            int[] curr = new int[s2.length() + 1];
            for (int j = 1; j <= s2.length(); j++) {
                curr[j] = s1.charAt(i - 1) == s2.charAt(j - 1)
                        ? prev[j-1] + 1
                        : Math.max(curr[j-1], prev[j]);
            }
            prev = curr;
        }
        return prev[s2.length()];
    }
}
