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
    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();

        helper(root, 0, 0, map);

        for (int key : map.keySet()) {
            List<Pair> temp = map.get(key);

            Collections.sort(temp, (a, b) -> {
                if (a.col != b.col) {
                    return a.col - b.col;
                }
                if (a.row != b.row) {
                    return a.row - b.row;
                }
                return a.node.val - b.node.val;
            });

            List<Integer> tmp = new ArrayList<>();
            for (Pair p : temp) {
                tmp.add(p.node.val);
            }

            result.add(tmp);
        }

        return result;

    }

    private void helper(TreeNode root, int row, int col, TreeMap<Integer, List<Pair>> map) {
        if (root == null) {
            return;
        }

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new Pair(root, row, col));

        helper(root.left, row + 1, col - 1, map);
        helper(root.right, row + 1, col + 1, map);
    }
}