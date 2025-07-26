/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            // Found the number
            if (nums[mid] == target) {
                return mid;
            } else  if (nums[mid] >= nums[left]) {
                // given, mid is greater than left, we are searching on higher side. Here we can have two conditions
                // 1. target is between left and mid, we need to update right
                if (target >= nums[left] && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    // 2. target should be on right side.
                    left = mid + 1;
                }
            } else {
                // left side is discarded, given target is smaller than left
                // 1. right > target > mid, search on further right
                if (target <= nums[right] && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    // 2. else from mid to pivot point, hence updating right to left side.
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
