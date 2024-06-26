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
    public TreeNode balanceBST(TreeNode root) {
        if(root == null){
            return null;
        }

        List<Integer> list = inorder(root, new ArrayList<>());

        return balance(list,0,list.size()-1);
    }
    private TreeNode balance(List<Integer> list, int low, int high){
        if(low > high){
            return null;
        }

        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = balance(list,low,mid-1);
        root.right = balance(list,mid+1,high);

        return root;
    }
    private List<Integer> inorder(TreeNode root,List<Integer> list){
        if(root == null){
            return list;
        }

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);

        return list;
    }
}