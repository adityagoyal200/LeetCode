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
import java.util.*;

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
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();

        // Helper method call to start populating the map
        helper(root, 0, 0, map);

        // Process each column in the map and sort by row, then node value
        for (List<Pair> pairs : map.values()) {
            // Sort pairs based on row first, then node value
            pairs.sort(Comparator
                    .comparingInt((Pair p) -> p.row)   // Sort by row
                    .thenComparingInt(p -> p.node.val)); // Then by node value

            List<Integer> colNodes = new ArrayList<>();
            for (Pair p : pairs) {
                colNodes.add(p.node.val);
            }
            result.add(colNodes);
        }

        return result;
    }

    private void helper(TreeNode root, int row, int col, TreeMap<Integer, List<Pair>> map) {
        if (root == null) {
            return;
        }

        map.computeIfAbsent(col, k -> new ArrayList<>()).add(new Pair(root, row, col));

        helper(root.left, row + 1, col - 1, map);
        helper(root.right, row + 1, col + 1, map);
    }
}
