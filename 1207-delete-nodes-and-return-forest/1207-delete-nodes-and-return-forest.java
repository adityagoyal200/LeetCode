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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int val : to_delete) {
            set.add(val);
        }

        if (!set.contains(root.val)) {
            list.add(root);
        }

        helper(root, set, list);
        return list;
    }

    private TreeNode helper(TreeNode root, HashSet<Integer> set, List<TreeNode> list) {
        if (root == null) {
            return null;
        }

        root.left = helper(root.left, set, list);
        root.right = helper(root.right, set, list);

        if (set.contains(root.val)) {
            if (root.left != null) {
                list.add(root.left);
            }
            if (root.right != null) {
                list.add(root.right);
            }
            return null;
        }

        return root;
    }
}
