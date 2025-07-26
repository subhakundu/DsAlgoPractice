/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 */
/**
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }
    private void dfs(TreeNode root, List<Integer> currentPath, List<String> result) {
        currentPath.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(printString(currentPath));
            currentPath.removeLast();
            return;
        }
        if (root.left != null) {
            dfs(root.left, currentPath, result);
        }
        if (root.right != null) {
            dfs(root.right, currentPath, result);
        }
        currentPath.removeLast();
    }
    private String printString(List<Integer> path) {
        String result = "";
        for (int i=0; i<path.size()-1; i++) {
            result += path.get(i);
            result+="->";
        }
        result+=path.get(path.size() - 1);
        return result;
    }
}
