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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) {
            return "";
        }
        String start = findPath(root, startValue, new StringBuilder());
        String dest = findPath(root, destValue, new StringBuilder());

        int i = 0;
        while (i < start.length() && i < dest.length() && start.charAt(i) == dest.charAt(i)) {
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = i; j < start.length(); j++) {
            sb.append('U');
        }

        sb.append(dest.substring(i));

        return sb.toString();
    }

    private String findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) {
            return "";
        }

        if (root.val == value) {
            return path.toString();
        }

        path.append('L');
        String leftPath = findPath(root.left, value, path);
        
        if (!leftPath.isEmpty()) {
            return leftPath;
        }

        path.setLength(path.length() - 1);

        path.append('R');

        String rightPath = findPath(root.right, value, path);

        if (!rightPath.isEmpty()) {
            return rightPath;
        }

        path.setLength(path.length() - 1);

        return "";
    }
}
