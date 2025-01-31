class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        n = len(nums)
        result = []

        for i in range(n):
            if i != 0 and nums[i] ==  nums[i-1]:
                continue
            
            j = i+1
            for j in range(i+1,n-1):
                if j > i+1 and nums[j] == nums[j-1]:
                    continue
                
                k = j+1
                l = n-1

                while k < l:
                    sum = nums[i] + nums[j] + nums[k] + nums[l]

                    if sum == target:
                        result.append([nums[i],nums[j],nums[k],nums[l]])
                        k = k +1
                        l = l-1
                        while k < l and nums[k] == nums[k-1]:
                            k = k+1
                        while k < l and nums[l] == nums[l+1]:
                            l = l-1
                    elif sum < target:
                        k = k+1
                    else:
                        l = l-1
            

        return result
            

