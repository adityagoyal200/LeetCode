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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        return findTargetHelper(root, k, set);
    }

    private boolean findTargetHelper(TreeNode node, int k, HashSet<Integer> set) {
        if (node == null) {
            return false;
        }

        int complement = k - node.val;

        if (set.contains(complement)) {
            return true;
        }

        set.add(node.val);

        return findTargetHelper(node.left, k, set) || findTargetHelper(node.right, k, set);
    }
}
