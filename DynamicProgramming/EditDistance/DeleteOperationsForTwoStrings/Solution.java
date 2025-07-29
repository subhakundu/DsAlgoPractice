/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }
        int row = len1+1, col = len2+1;
        int [][] dp = new int[row][col];
        for(int i=0; i<row; i++) {
            dp[i][0] = i;
        }
        for(int i=0; i<col; i++) {
            dp[0][i] = i;
        }
        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                // if equal characters, same as previous parts of the strings
                // remember to adjust the index. Matrix index is increased by 1.
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // Else, plus one to minimum of deletion from either string
                    // 1 + min(deletion from word1, deletion from word2)
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[row-1][col-1];
    }
}
