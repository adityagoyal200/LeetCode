class Solution(object):
    def subsetsWithDup(self, nums):
        nums.sort()
        result = []
        
        def backtrack(start, path):
            result.append(path[0:])
            
            for i in range(start, len(nums)):
                if i > start and nums[i] == nums[i - 1]:
                    continue
                backtrack(i + 1, path + [nums[i]])
        
        backtrack(0, [])
        return result
