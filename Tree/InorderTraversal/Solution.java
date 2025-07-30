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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> inorderStack = new Stack<>();
        TreeNode node = root;
        while(node != null || !inorderStack.isEmpty()) {
            while(node != null) {
                inorderStack.push(node);
                node = node.left;
            }
            node = inorderStack.pop();
            result.add(node.val);
            // No need to push the right node in the stack.
            node = node.right;
        }
        return result;
    }
}
