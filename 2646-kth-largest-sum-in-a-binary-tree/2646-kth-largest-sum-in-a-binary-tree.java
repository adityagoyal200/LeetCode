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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null || k == 0){
            return 0;
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                sum += (long)temp.val;
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
            if(pq.size() < k){
                pq.offer(sum);
            } else if(pq.peek() < sum) {
                pq.poll();
                pq.offer(sum);
            }
        }

        return pq.size() < k ? -1 : pq.peek();
    }
}