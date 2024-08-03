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
    private int count = 0;
    public int averageOfSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root);

        return count;
    }
    private Pair<Integer,Integer> helper(TreeNode root){
        if(root == null){
            return new Pair<>(0,0);
        }

        Pair<Integer,Integer> left = helper(root.left);
        Pair<Integer,Integer> right = helper(root.right);

        int currentVal = root.val;
        int sum = left.getKey()+right.getKey()+root.val;
        int totalNodes = 1+left.getValue() + right.getValue();


        if(currentVal == sum/totalNodes){
            count++;
        }

        return new Pair<>(sum,totalNodes);
    }
}