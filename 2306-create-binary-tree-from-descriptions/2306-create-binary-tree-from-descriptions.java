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
    public TreeNode createBinaryTree(int[][] descriptions) {
        if (descriptions == null || descriptions.length == 0) {
            return null;
        }

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] node : descriptions) {
            int par = node[0];
            int child = node[1];
            int isLeft = node[2];


            TreeNode parent = map.getOrDefault(par, new TreeNode(par));
            map.put(par, parent);

            TreeNode childNode = map.getOrDefault(child, new TreeNode(child));
            map.put(child, childNode);

            if (isLeft == 1) {
                parent.left = childNode;
            } else {
                parent.right = childNode;
            }

            children.add(child);
        }

        for (int key : map.keySet()) {
            if (!children.contains(key)) {
                return map.get(key);
            }
        }

        return null;
    }
}
