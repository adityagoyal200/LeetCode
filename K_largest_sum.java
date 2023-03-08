/*You are given the root of a binary tree and a positive integer k.
The level sum in the tree is the sum of the values of the nodes that are on the same level.
Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.
Note that two nodes are on the same level if they have the same distance from the root. */
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

 class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k){
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
    
        while(!queue.isEmpty()){
            count = queue.size();
            Long sum = (long) 0;
            while(count > 0){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                count--;
            }
            if(pq.size() < k){
                pq.offer(sum);
            } 
            else if(pq.peek() < sum){
                pq.poll();
                pq.offer(sum);
            }
        }
        return pq.size() < k? -1: pq.peek();
    }
}
/*The code uses a PriorityQueue (a min heap implementation) to store the k largest level sums encountered so far. It also uses a Queue to traverse the binary tree level by level, starting from the root.
In the main loop, for each level, the sum of node values is calculated and added to the PriorityQueue. If the PriorityQueue has not reached k elements yet, the current sum is added without any further checks. Otherwise, the current sum is compared to the smallest element in the PriorityQueue (the top element), and if it is greater, the smallest element is removed and the current sum is added.
Finally, if the PriorityQueue has less than k elements, the function returns -1. Otherwise, it returns the smallest element in the PriorityQueue (which is the k-th largest level sum). */