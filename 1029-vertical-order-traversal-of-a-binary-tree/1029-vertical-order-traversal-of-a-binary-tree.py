class Solution(object):
    def verticalTraversal(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        if not root:
            return []

        node_list = []  
        
        def dfs(node, row, col):
            if not node:
                return
            node_list.append((col, row, node.val))
            dfs(node.left, row + 1, col - 1)
            dfs(node.right, row + 1, col + 1)
        
        dfs(root, 0, 0)
        node_list.sort() 
        
        result = defaultdict(list)
        for col, row, val in node_list:
            result[col].append(val)
        
        return [result[key] for key in sorted(result.keys())]
