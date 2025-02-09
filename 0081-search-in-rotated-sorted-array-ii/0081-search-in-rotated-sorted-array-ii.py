class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        if not nums:
            return False
        
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return True

            if nums[low] == nums[mid] == nums[high]:
                low += 1
                high -= 1

            elif nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:  
                    high = mid - 1  
                else:
                    low = mid + 1  
                                
            else:
                if nums[mid] < target <= nums[high]:  
                    low = mid + 1  
                else:
                    high = mid - 1  

        return False
