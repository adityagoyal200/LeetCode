/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();

        findElement(root, p, listP);
        findElement(root, q, listQ);

        int i = 0;
        for (; i < listP.size() && i < listQ.size() && listP.get(i) == listQ.get(i); ) {
            i++;
        }

        return listP.get(i - 1);
    }

    private void findElement(TreeNode root, TreeNode target, List<TreeNode> path) {
        while (root != null) {
            path.add(root);
            if (root.val == target.val) {
                return;
            } else if (root.val < target.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
}
