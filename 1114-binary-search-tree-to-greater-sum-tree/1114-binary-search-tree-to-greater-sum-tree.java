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
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root, 0);
        return root;
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }

        sum = helper(root.right, sum);

        root.val += sum;

        sum = root.val;
        sum = helper(root.left, sum);

        return sum;
    }
}
