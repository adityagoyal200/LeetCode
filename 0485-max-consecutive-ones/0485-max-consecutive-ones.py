class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_ones = 0
        ones = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                ones = ones+1
            if nums[i] == 0:
                max_ones = max(max_ones,ones)
                ones = 0
        
        max_ones = max(max_ones,ones)
        return max_ones

        