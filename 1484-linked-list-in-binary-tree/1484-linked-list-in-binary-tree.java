class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        
        return helper(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean helper(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root.val != head.val) {
            return false;
        }

        return helper(root.left, head.next) || helper(root.right, head.next);
    }
}
