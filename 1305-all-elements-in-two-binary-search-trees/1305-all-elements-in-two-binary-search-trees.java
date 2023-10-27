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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return new ArrayList<>();
        }
        
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        helper(root1,ans1);
        helper(root2,ans2);

        int i = 0;
        int j = 0;
        
        while(i < ans1.size() && j < ans2.size()){
            if(ans1.get(i) < ans2.get(j)){
                result.add(ans1.get(i));
                i++;
            } else if(ans1.get(i) > ans2.get(j)){
                result.add(ans2.get(j));
                j++;
            } else{
                result.add(ans1.get(i));
                result.add(ans2.get(j));
                i++;
                j++;
            }
        }
        
        while(i < ans1.size()){
            result.add(ans1.get(i));
            i++;
        }
        while(j < ans2.size()){
            result.add(ans2.get(j));
            j++;
        }

        return result;
    }
    private void helper(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }

        helper(root.left,ans);
        ans.add(root.val);
        helper(root.right,ans);
    }
}