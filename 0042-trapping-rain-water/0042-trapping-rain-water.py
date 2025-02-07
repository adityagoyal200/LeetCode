class Solution:
    def trap(self, height):
        if not height:
            return 0

        total = 0
        left, right = 0, len(height) - 1
        max_left, max_right = 0, 0

        while left <= right:
            if height[left] <= height[right]:
                if max_left <= height[left]:
                    max_left = height[left]
                else:
                    total += max_left - height[left]
                left += 1
            else:
                if max_right <= height[right]:
                    max_right = height[right]
                else:
                    total += max_right - height[right]
                right -= 1

        return total
