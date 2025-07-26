/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        while(!bfsQueue.isEmpty()) {
            int queueSize = bfsQueue.size();
            List<Integer> currentLevel = new ArrayList<>();
            while(queueSize-- > 0) {
                TreeNode current = bfsQueue.poll();
                currentLevel.add(current.val);
                if (current.left != null) {
                    bfsQueue.offer(current.left);
                }
                if (current.right != null) {
                    bfsQueue.offer(current.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
