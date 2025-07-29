/**
 * https://leetcode.com/problems/maximum-subarray/
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];

        for(int i=1; i<nums.length; i++) {
            nums[i] = Math.max(nums[i-1] + nums[i], nums[i]);
            maxSoFar = Math.max(nums[i], maxSoFar);
        }
        return maxSoFar;
    }
}
