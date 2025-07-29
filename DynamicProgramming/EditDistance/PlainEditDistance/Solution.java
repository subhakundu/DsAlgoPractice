/**
 * https://leetcode.com/problems/edit-distance/
 * Approach:
 * if word1 is Empty: return word2.length
 * if word2 is Empty: return word1.length
 * if (word1 == word2) return 0
 * loop through pair of characters
 * 1. If both are same, the changes will be same previous parts of both strings
 * 2. Else minimum (replace, deletion and insertion)
 */
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        if (word1.equals(word2)) {
            return 0;
        }
        int row = word1.length()+1, col = word2.length()+1;
        int [][] dp = new int[row][col];

        // Converting word1 to empty string
        for (int i=0; i<row; i++) {
            dp[i][0] = i;
        }
        // Converting empty string to word2
        for (int i=0; i<col; i++) {
            dp[0][i] = i;
        }
        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                // index has to be adjusted
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // Min(insertion, Min(replace, deletion)) + 1
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[row-1][col-1];
    }
}
