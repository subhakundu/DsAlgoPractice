/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
       int n = nums.length;
       int[] length = new int[n];
       int[] count = new int[n];

       Arrays.fill(length, 1);
       Arrays.fill(count, 1);
       int maxLength = 1;
       for(int i=0; i<n; i++) {
        for(int j=0; j<i; j++) {
            if(nums[j] < nums[i]) {
                if (length[j] + 1 > length[i]) {
                    length[i] = length[j] + 1;
                    count[i] = 0;
                }
                maxLength = Math.max(maxLength, length[i]);
                if (length[i] == length[j] + 1) {
                    count[i] += count[j];
                }
            }
        }
       }
       int result = 0;
       for (int i=0; i<n; i++) {
        if (length[i] == maxLength) {
            result += count[i];
        }
       }
       return result;
    }
}
