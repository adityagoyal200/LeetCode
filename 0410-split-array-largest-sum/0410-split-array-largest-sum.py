class Solution:
    def splitArray(self, nums, k):
        if not nums or len(nums) < k:
            return -1

        low, high = max(nums), sum(nums)

        while low <= high:
            mid = low + (high - low) // 2
            sub_arrays = self.isPossible(nums, mid)

            if sub_arrays > k:
                low = mid + 1
            else:
                high = mid - 1

        return low

    def isPossible(self, arr, target_sum):
        curr_arr = 1
        curr_sum = 0

        for num in arr:
            if curr_sum + num <= target_sum:
                curr_sum += num
            else:
                curr_arr += 1
                curr_sum = num

        return curr_arr
