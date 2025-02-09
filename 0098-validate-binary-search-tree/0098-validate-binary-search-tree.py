# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.prev = None

    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        return self.inorder(root)

    def inorder(self, root):
        if not root:
            return True

        if not self.inorder(root.left):  
            return False

        if self.prev and self.prev.val >= root.val:
            return False

        self.prev = root

        return self.inorder(root.right)
