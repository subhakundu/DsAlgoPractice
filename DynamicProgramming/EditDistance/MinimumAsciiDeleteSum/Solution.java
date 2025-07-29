/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
 * This is basically tracing the transformation.
 */
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int row = len1+1, col = len2+1;
        int [][] dp = new int[row][col];
        dp[0][0] = 0;
        for(int i=1; i<row; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for(int i=1; i<col; i++) {
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }
        for(int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
                }
            }
        }
        return dp[row-1][col-1];
    }
}
