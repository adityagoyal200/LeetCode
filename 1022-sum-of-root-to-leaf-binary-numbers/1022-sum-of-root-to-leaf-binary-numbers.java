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
    int sum;

    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        if (root == null) {
            return 0; 
        }

        helper(root, new StringBuilder());

        return sum;
    }

    public void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        
        sb.append(String.valueOf(root.val));

        if (root.left == null && root.right == null) {
            sum += getDecimal(sb.toString());
        }

        helper(root.left, new StringBuilder(sb));  
        helper(root.right, new StringBuilder(sb));
    }

    public int getDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            decimal = decimal * 2 + (c - '0');
        }
        return decimal;
    }
}

