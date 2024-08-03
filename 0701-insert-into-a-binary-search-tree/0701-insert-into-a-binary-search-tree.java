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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode temp = new TreeNode (val);
            return temp;
        }

        return helper(root,val);
    }
    private TreeNode helper(TreeNode root, int val){
        if(root == null){
            TreeNode temp = new TreeNode(val);
            return temp; 
        }

        if(root.val < val){
            root.right = helper(root.right, val);
        } else {
            root.left = helper(root.left, val); 
        }

        return root;
    }

}