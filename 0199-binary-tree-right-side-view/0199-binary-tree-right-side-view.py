class Solution:
    def rightSideView(self, root):
        if not root:
            return []

        result = []
        queue = deque([root])

        while queue:
            result.append(queue[-1].val)
            for _ in range(len(queue)):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return result
