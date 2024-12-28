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
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new HashMap<>());
    }

    private int dfs(TreeNode node, int depth, int position, Map<Integer, Integer> leftMost) {
        if (node == null) {
            return 0;
        }

        leftMost.putIfAbsent(depth, position);

      
        int currentWidth = position - leftMost.get(depth) + 1;

    
        int leftWidth = dfs(node.left, depth + 1, position * 2, leftMost);
        int rightWidth = dfs(node.right, depth + 1, position * 2 + 1, leftMost);

    
        return Math.max(currentWidth, Math.max(leftWidth, rightWidth));
    }
}