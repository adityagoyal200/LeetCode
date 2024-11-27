/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
      if (root == null) {
          return "";  
      }
      List<String> list = new ArrayList<>();
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      
      while (!q.isEmpty()) {
          TreeNode temp = q.poll();
          if (temp != null) {
              list.add(Integer.toString(temp.val));  
              q.offer(temp.left);
              q.offer(temp.right);
          } else {
              list.add("null");
          }
      }
      while (list.get(list.size() - 1).equals("null")) {
          list.remove(list.size() - 1);
      }
      return String.join(",", list);  
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        
        for (int i = 1; i < nodes.length; i++) {
            TreeNode parent = q.poll();
            if(!nodes[i].equals("null")){
              TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
              parent.left = left;
              q.offer(left);
            }
            i++;
            if(i < nodes.length && !nodes[i].equals("null")){
              TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
              parent.right = right;
              q.offer(right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));