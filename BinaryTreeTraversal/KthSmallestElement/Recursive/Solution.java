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
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = inorder(root, new ArrayList<>());
        return nums.get(k-1);
    }
    private List<Integer> inorder(TreeNode root, List<Integer> arr) {
        if(root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}
