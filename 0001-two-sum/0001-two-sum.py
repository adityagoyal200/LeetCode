class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = {}
        for i in range (len(nums)):
            diff = target - nums[i]
            if diff in map:
                return [i,map[diff]]
            else:
                map[nums[i]] = i
        