/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
//left right root

class Solution {
    List<Integer> result;
    public List<Integer> postorder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root);

        return result;
    }
    private void dfs(Node root){
        if(root == null){
            return;
        }
        
        for(Node node: root.children){
            dfs(node);
        }
        
        result.add(root.val);
    }
}