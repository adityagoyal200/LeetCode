/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            List<Integer> result = new ArrayList<>();
            if(root == null || root.left == null && root.right == null & k>0){
                return result;
            }
            if(k == 0 && target != null){
                result.add(target.val);
                return result;
            }
            HashMap<TreeNode,TreeNode> map = new HashMap<>();
            int distance = 0;
            Queue<TreeNode> parent = new LinkedList<>();
            parent.offer(root);
            map.put(root,null);
            while(!parent.isEmpty()){
                int size = parent.size();
                for(int i=0;i<size;i++){
                    TreeNode temp = parent.poll();
                    if(temp.left!=null){
                        parent.offer(temp.left);
                        map.put(temp.left,temp);
                    }
                    if(temp.right!=null){
                        parent.offer(temp.right);
                        map.put(temp.right,temp);
                    }
                }
            }
            
            List<TreeNode> visited = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(target);//
            visited.add(target);
            while(!q.isEmpty()){ 
                int size = q.size();// 
                for(int i =0 ;i<size;i++){
                    TreeNode temp = q.poll();// 3
                    if(temp.left!=null &&  !visited.contains(temp.left)){
                     q.offer(temp.left);
                     visited.add(temp.left); //
                    }
                    if(temp.right!=null && !visited.contains(temp.right)){
                     q.offer(temp.right);
                     visited.add(temp.right);
                    }
                    if(map.get(temp) != null && !visited.contains(map.get(temp))){
                        q.offer(map.get(temp)); 
                        visited.add(map.get(temp));
                    }
                }
                distance++;//2
                if(distance == k){
                 break;
                }
            }
            while(!q.isEmpty()){
                result.add(q.poll().val);
            } 

        return result;
    }
}      