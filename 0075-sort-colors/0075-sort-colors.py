class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """  
        low = 0
        mid = 0
        high = len(nums) -1

        while mid <= high:
            if nums[mid] == 1:
                mid = mid+1
            elif nums[mid] == 0:
                self.swap(nums,low,mid)
                low = low+1
                mid = mid+1
            else:
                self.swap(nums,mid,high)
                high = high-1
        
    def swap(self,nums,left,right):
        temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp