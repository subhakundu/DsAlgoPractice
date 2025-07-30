/**
 * https://leetcode.com/problems/longest-common-subsequence/description/
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();

        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        int [][] dp = new int[len1+1][len2+1];

        // Initial values has to be 0, because empty values, and
        // any string does not have any common subsequence.
        for(int i=0; i<=len1; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<=len2; i++) {
            dp[0][i] = 0;
        }
        for(int i=1; i<=len1; i++) {
            for (int j=1; j<=len2; j++) {
                // if two strings have same characters, that has to be included.
                // Hence, plus 1.
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // otherwise, max of three cases (both chars dropped, or one char included from either included)
                    // Why three parts? because characters from either string cab be part of common sequence derived from previous computations.
                    dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[len1][len2];
    }
}
