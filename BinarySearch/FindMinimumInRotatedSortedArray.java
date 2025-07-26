/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length-1]) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1, mid = 0;
        while(left <= right) {
            mid = left + (right - left)/2;
            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            } else if (nums[left] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
