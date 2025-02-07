class Solution:
    def insertIntoBST(self, root, val):
        if not root:
            return TreeNode(val)

        temp = root
        while True:
            if val > temp.val:
                if not temp.right:
                    temp.right = TreeNode(val)
                    break
                temp = temp.right
            else:
                if not temp.left:
                    temp.left = TreeNode(val)
                    break
                temp = temp.left

        return root
