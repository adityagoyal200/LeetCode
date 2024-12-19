/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();

        findElement(root, p, listP);
        findElement(root, q, listQ);

        int i = 0;
        while (i < listP.size() && i < listQ.size() && listP.get(i).val == listQ.get(i).val) {
            i++;
        }

        if (i == 0) {
            return null;
        }

        return (i < listP.size()) ? listP.get(i-1): listQ.get(i-1);
    }

    private void findElement(TreeNode node, TreeNode target, List<TreeNode> path) {
        if (node == null) {
            return;
        }

        path.add(node);

        if (node.val == target.val) {
            return;
        }

        findElement(node.left, target, path);
        if (path.get(path.size() - 1) == target) {
            return;
        }

        findElement(node.right, target, path);
        if (path.get(path.size() - 1) == target) {
            return;
        }

        path.remove(path.size() - 1);
    }
}