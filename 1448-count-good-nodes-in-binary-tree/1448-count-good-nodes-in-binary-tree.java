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
    int good;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        good = 1;
        helper(root.left,root.val);//1 ,3
        helper(root.right,root.val);// 4,3

        return good;
    }
    private void helper(TreeNode root, int max){
        if(root == null){
            return;
        }

        if(root.val >= max){ 
            good++;
            max = root.val;
        }
        
        helper(root.left,max); 
        helper(root.right,max);
    }
}