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
    public int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }

        Map<Integer, List<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                int val = temp.val;
                map.putIfAbsent(val, new ArrayList<>());

                if (temp.left != null) {
                    q.offer(temp.left);
                    map.get(val).add(temp.left);
                    map.putIfAbsent(temp.left.val, new ArrayList<>());
                    map.get(temp.left.val).add(temp);
                }

                if (temp.right != null) {
                    q.offer(temp.right);
                    map.get(val).add(temp.right);
                    map.putIfAbsent(temp.right.val, new ArrayList<>());
                    map.get(temp.right.val).add(temp);
                }
            }
        }

        if (!map.containsKey(start)) {
            return -1; 
        }

        Queue<Integer> q2 = new LinkedList<>();
        q2.offer(start);
        Set<Integer> visited = new HashSet();
        int time = 0;

        while (!q2.isEmpty()) {
            int size = q2.size();
            for (int i = 0; i < size; i++) {
                int temp = q2.poll();
                visited.add(temp);
                for (TreeNode node : map.get(temp)) {
                    if (!visited.contains(node.val)) {
                        q2.offer(node.val);
                    }
                }
            }
            time++;
        }

        return time - 1; 
    }
}



