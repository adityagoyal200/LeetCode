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
    private int minSwaps(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(sorted[i], i);
        }
        
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || indexMap.get(arr[i]) == i) {
                continue; 
            }
            
            int cycleSize = 0;
            int current = i;
            while (!visited[current]) {
                visited[current] = true;
                current = indexMap.get(arr[current]);
                cycleSize++;
            }
            swaps += (cycleSize - 1); 
        }
        return swaps;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int totalSwaps = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int[] levelValues = new int[levelSize];
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelValues[i] = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            totalSwaps += minSwaps(levelValues);
        }

        return totalSwaps;
    }
}
