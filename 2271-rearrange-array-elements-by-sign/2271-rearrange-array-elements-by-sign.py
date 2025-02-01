class Solution(object):
    def rearrangeArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = [0] * len(nums)
        neg = 1
        pos = 0
        
        for i in range(len(nums)):
            if nums[i] < 0:
                result[neg] = nums[i]
                neg = neg+2
            if nums[i] > 0:
                result[pos] = nums[i]
                pos = pos+2
        
        return result