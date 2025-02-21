class FindElements {
    private final HashSet<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        set.add(0);
        root.val = 0;
        recover(root);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    private void recover(TreeNode node) {
        if (node.left != null) {
            node.left.val = (node.val << 1) + 1;
            set.add(node.left.val);
            recover(node.left);
        }
        if (node.right != null) {
            node.right.val = (node.val << 1) + 2;
            set.add(node.right.val);
            recover(node.right);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */