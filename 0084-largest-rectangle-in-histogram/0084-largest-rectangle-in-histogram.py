class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if not heights:
            return 0
        
        stack = []
        largest = 0
        
        for i in range(len(heights)):
            while stack and heights[stack[-1]] >= heights[i]:
                index = stack.pop()
                nse = i
                pse = stack[-1] if stack else -1
                largest = max(largest, heights[index] * (nse - pse - 1))
            stack.append(i)
        
        while stack:
            index = stack.pop()
            nse = len(heights)
            pse = stack[-1] if stack else -1
            largest = max(largest, heights[index] * (nse - pse - 1))
        
        return largest
