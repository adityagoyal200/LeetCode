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
class FindElements {
    HashSet<Integer> set;
    TreeNode root;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        this.root = root;
        root.val = 0;
        set.add(0);
        dfs(root);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    private void dfs(TreeNode root){
        if(root == null) return;
        
        if(root.right != null){
            root.right.val = (root.val * 2) + 2;
            set.add(root.right.val);
            dfs(root.right);
        }
        if(root.left != null){
            root.left.val = (root.val*2) + 1;
            set.add(root.left.val);
            dfs(root.left);
        }   
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */