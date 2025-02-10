# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def helper(root, currSum):
            if root is None:
                return 0

            currSum = currSum * 10 + root.val

            if root.left is None and root.right is None:
                return currSum  

            leftSum = helper(root.left, currSum)
            rightSum = helper(root.right, currSum)

            return leftSum + rightSum 

        return helper(root, 0)

        