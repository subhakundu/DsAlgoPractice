/**
 * https://leetcode.com/problems/shortest-common-supersequence/description/
 */
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        String[] prevRow = new String[len2 + 1];

        for (int i=0; i<=len2; i++) {
            prevRow[i] = str2.substring(0, i);
        }
        for (int i=1; i<=len1; i++) {
            String[] currRow = new String[len2+1];
            currRow[0] = str1.substring(0, i);
            for (int j=1; j<=len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    currRow[j] = prevRow[j-1] + str1.charAt(i-1);
                } else {
                    String s1 = prevRow[j];
                    String s2 = currRow[j-1];
                    currRow[j] = (s1.length() < s2.length()) ?
                        s1 + str1.charAt(i-1) : s2 + str2.charAt(j-1);
                }
            }
            prevRow = currRow;
        }
        return prevRow[len2];
    }
}
