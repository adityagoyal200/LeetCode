/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Integer,Node>map=new HashMap<>();

    public Node cloneGraph(Node node) {
        
        return clone(node);
    }
    public Node clone(Node node){
        if(node==null) return null;
        
        if(map.containsKey(node.val)) return map.get(node.val);
        
        map.put(node.val,new Node(node.val));

        for(Node n:node.neighbors) map.get(node.val).neighbors.add(clone(n));
        
        return map.get(node.val);
    }
}