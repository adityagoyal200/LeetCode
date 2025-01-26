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
    HashMap<Integer, Integer> map;
    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return treeBuild(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode treeBuild(int[] preorder, int[] inorder, int start, int end) {

        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int rootIndex = map.get(root.val);
        root.left = treeBuild(preorder, inorder, start, rootIndex - 1);
        root.right = treeBuild(preorder, inorder, rootIndex + 1, end);
        return root;
    }
}