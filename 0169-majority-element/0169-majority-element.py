class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        majority = nums[0]
        count = 0
        for i in range(len(nums)):
            if nums[i] == majority:
                count = count+1
            if nums[i] != majority:
                count = count-1
            if count == 0:
                majority = nums[i]
                count = count+1
        
        return majority
        