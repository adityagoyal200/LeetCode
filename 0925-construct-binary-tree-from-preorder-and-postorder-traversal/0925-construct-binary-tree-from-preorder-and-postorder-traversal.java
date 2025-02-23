class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> postIndexMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return construct(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int l, int h) {
        if (l > h) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (l == h) return root;

        int leftIndex = postIndexMap.get(preorder[preIndex]); 
        
        root.left = construct(preorder, postorder, l, leftIndex);
        root.right = construct(preorder, postorder, leftIndex + 1, h - 1);

        return root;
    }
}
