class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        stack = []
        
        for ast in asteroids:
            if not stack or ast > 0:
                stack.append(ast)
            else:
                while stack and stack[-1] > 0 and stack[-1] < abs(ast):
                    stack.pop()
                if not stack or stack[-1] < 0:
                    stack.append(ast)
                elif stack[-1] == abs(ast):
                    stack.pop()
        
        return stack
