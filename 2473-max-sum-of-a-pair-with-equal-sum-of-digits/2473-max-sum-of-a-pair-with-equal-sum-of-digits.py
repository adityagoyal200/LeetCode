class Solution:
    def maximumSum(self, nums):
        mp = [0] * 82  
        ans = -1

        for num in nums:
            sum_digits = sum(int(d) for d in str(num))

            if mp[sum_digits]:
                ans = max(ans, num + mp[sum_digits])

            mp[sum_digits] = max(mp[sum_digits], num)

        return ans
