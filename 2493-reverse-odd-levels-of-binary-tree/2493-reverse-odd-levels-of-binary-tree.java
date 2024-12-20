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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverseLevel = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> levelNodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levelNodes.add(node);

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            if (reverseLevel) {
                for (int left = 0, right = levelNodes.size() - 1; left < right; left++, right--) {
                    int tempVal = levelNodes.get(left).val;
                    levelNodes.get(left).val = levelNodes.get(right).val;
                    levelNodes.get(right).val = tempVal;
                }
            }

            reverseLevel = !reverseLevel;
        }

        return root;
    }
}
