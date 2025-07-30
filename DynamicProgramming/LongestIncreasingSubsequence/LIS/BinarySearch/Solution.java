/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
class Solution {
    /**
     * Premise of this solution is that we do not need to keep track of the
     * LIS, but only the length. We will construct the LIS, and return the
     * length.
     */
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i=1; i<nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        return sub.size();
    }
    private int binarySearch(List<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if (num == sub.get(mid)) {
                return mid;
            } else if (num < sub.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
