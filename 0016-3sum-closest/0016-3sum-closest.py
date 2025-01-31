class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if nums is None or len(nums) < 3:
            return -1

        nums.sort()
        closest = nums[0] + nums[1] + nums[2]

        for i in range(len(nums)):
            j = i+1
            k = len(nums)-1
            while j < k:
                sum =  nums[i] + nums[j] + nums[k]
                if(sum == target):
                    return target
                if(abs(target-sum) < abs(target-closest)):
                    closest = sum
                
                if sum < target:
                    j = j+1
                else:
                    k = k-1
    
        return closest
        