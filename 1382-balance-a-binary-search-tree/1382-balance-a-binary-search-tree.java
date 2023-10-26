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
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        TreeNode ans = null;
        inOrder(root);
        ans = balanceBST(list,0,list.size()-1);
        return ans;
    }
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    public TreeNode balanceBST(List<Integer> list, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(list.get(mid));
        if(start == end) {
            return root;
        }
        root.left = balanceBST(list, start, mid-1);
        root.right = balanceBST(list, mid+1, end);
        return root;
    }
    
}