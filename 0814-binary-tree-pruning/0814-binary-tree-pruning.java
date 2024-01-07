/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Use the helper function to prune left and right subtrees
        root.left = helper(root.left);
        root.right = helper(root.right);

        // Check the condition for pruning the current node
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }

        return root;
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Recursively prune left and right subtrees
        root.left = helper(root.left);
        root.right = helper(root.right);

        // Check the condition for pruning the current node
        if (root.val == 0 && root.left == null && root.right == null) {
            // If the current node is 0 and has no children, prune it by returning null
            return null;
        }

        // Return the modified root
        return root;
    }
}
