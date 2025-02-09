# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        if root is None:
            return True
        
        return self.helper(root.left,root.right)
    
    def helper(self,leftTree,rightTree):
        if leftTree is None and rightTree is None:
            return True
        
        if leftTree is None or rightTree is None or leftTree.val != rightTree.val:
            return False
        

        return self.helper(leftTree.left,rightTree.right) and self.helper(leftTree.right,rightTree.left)
        