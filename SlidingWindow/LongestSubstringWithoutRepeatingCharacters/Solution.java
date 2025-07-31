/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        int maxLength = 0, start = 0, end = 0;
        for (int i=0; i<s.length(); i++) {
            if (countMap.containsKey(s.charAt(i))) {
                int previous = countMap.get(s.charAt(i));
                if (previous >= start) {
                    start = previous + 1;
                }
            }
            end = i;
            countMap.put(s.charAt(i), i);
            int length = end - start + 1;
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}
