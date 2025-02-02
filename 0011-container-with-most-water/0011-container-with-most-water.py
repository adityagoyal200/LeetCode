class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        max_area = 0
        left = 0
        right = len(height)-1

        while(left < right):
            curr_height = min(height[left],height[right])
            curr_water = curr_height*(right-left)
            max_area = max(max_area,curr_water)
            
            while(left < right and height[left] <= curr_height):
                left += 1
            while(left < right and height[right] <= curr_height):
                right -= 1
        
        return max_area

        