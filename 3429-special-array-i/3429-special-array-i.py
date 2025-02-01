class Solution(object):
    def isArraySpecial(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if nums is None or len(nums) <=1:
            return True

        for i in range(1,len(nums)):
            if nums[i] % 2 == 0:
                if nums[i-1] %2 == 0:
                    return False
                if i+1 < len(nums) and nums[i+1] % 2 == 0:
                    return False
            else:
                if nums[i-1] %2 != 0:
                    return False
                if i+1 < len(nums) and nums[i+1] % 2 != 0:
                    return False
        
        return True


        