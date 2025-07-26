/**
 * https://leetcode.com/problems/subsets/description/
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length == 0) {
            return result;
        }
        for(int i=0; i<nums.length; i++) {
            backTrackingUtil(nums, i, new ArrayList<>(), result);
        }
        return result;
    }
    private void backTrackingUtil(int[] nums, int currentIndex, List<Integer> currentSet, List<List<Integer>> result) {
        currentSet.add(nums[currentIndex]);
        result.add(new ArrayList<>(currentSet));
        for (int i=currentIndex+1; i<nums.length; i++) {
            if (!currentSet.contains(nums[i])) {
                backTrackingUtil(nums, i, currentSet, result);
            }
            currentSet.removeLast();
        }
    }
}
