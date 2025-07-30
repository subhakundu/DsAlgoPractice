/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int maxValue = 1;
        Arrays.fill(dp, 1);
        for (int i=1; i<nums.length; i++) {
            for (int j=i; j>=0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxValue = Math.max(dp[i], maxValue);
                }
            }
        }
        return maxValue;
    }
}
