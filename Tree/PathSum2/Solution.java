/**
 * https://leetcode.com/problems/path-sum-ii/description/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }
    /**
     * Whenver targetSum is 0, that means we have found a path.
     * Add it to the result list.
     */
    private void dfs(TreeNode node, int targetSum, List<Integer>currentPath, List<List<Integer>> result) {
        if(node == null) {
            return;
        }
        currentPath.add(node.val);
        targetSum-=node.val;
        if (node.left == null && node.right == null && targetSum==0) {
            result.add(new ArrayList<>(currentPath));
            currentPath.removeLast();
            return;
        }
        if (node.left != null) {
            dfs(node.left, targetSum, currentPath, result);
        }
        if (node.right != null) {
            dfs(node.right, targetSum, currentPath, result);
        }
        currentPath.removeLast();
    }
}
