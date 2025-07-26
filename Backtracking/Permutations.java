/**
 * Leetcode: https://leetcode.com/problems/permutations/description/
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length > 0) {
            permutationGenerator(nums, new ArrayList<>(), result);   
        }
        return result;
    }
    private void permutationGenerator(int[] nums, List<Integer> currentSubset, List<List<Integer>> result) {
        if (currentSubset.size() == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (currentSubset.contains(nums[i])) {
                continue;
            }
            currentSubset.add(nums[i]);
            permutationGenerator(nums, currentSubset, result);
            currentSubset.removeLast();
        }
    }
}
