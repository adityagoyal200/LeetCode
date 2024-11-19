class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (right - left + 1 > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            if (right - left + 1 == k && map.size() == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
