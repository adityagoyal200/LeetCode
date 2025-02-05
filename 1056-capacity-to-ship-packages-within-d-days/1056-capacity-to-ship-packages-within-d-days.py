class Solution:
    def shipWithinDays(self, weights, days):
        if not weights or days == 0:
            return -1

        low, high = max(weights), sum(weights)

        while low <= high:
            mid = low + (high - low) // 2

            if self.isPossible(weights, mid, days):
                high = mid - 1
            else:
                low = mid + 1

        return low

    def isPossible(self, arr, cap, max_days):
        day, curr = 1, 0

        for weight in arr:
            curr += weight

            if curr > cap:
                day += 1
                curr = weight

        return day <= max_days
