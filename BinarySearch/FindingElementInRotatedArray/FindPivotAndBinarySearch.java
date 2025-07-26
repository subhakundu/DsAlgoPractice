/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || (nums.length==1 && nums[0] != target)) {
            return -1;
        }
        /**
         * If first number is less than last number, that means
         * it had not been rotated. Then we just perform regular
         * binary search and return the value.
         */
        if (nums[0] <= nums[nums.length-1]) {
            return performBinarySearchAndReturnIndex(nums, target, 0, nums.length - 1);
        }
        /**
         * Else we find the pivot element.
         */
         int left = 0, right = nums.length - 1, pivot = 0;
         while (left <= right) {
            pivot = left + (right - left)/2;
            // we have found pivot element.
            if (nums[pivot] > nums[pivot + 1]) {
                break;
            } else if (nums[pivot] < nums[left]) {
                // it must be on the higher side, i.e., left side.
                right = pivot -1;
            } else {
                // it must be on the lower side, i.e., right side.
                left = pivot + 1;
            }
         }
         right = nums.length - 1;
         // assuming we have pivot element, now perform binary search.
         if (nums[pivot] > target && nums[right]>=target) {
            // search on lower side, i.e., on right side.
            return performBinarySearchAndReturnIndex(nums, target, pivot + 1, right);
         }
        // search on higher side, i.e., on left side.
        return performBinarySearchAndReturnIndex(nums, target, 0, pivot);
    }
    private int performBinarySearchAndReturnIndex(int[] nums, int target, int left, int right) {
        while (left<=right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
