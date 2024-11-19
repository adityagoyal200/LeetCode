class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }

        int left = 0;
        long sum = 0;
        long max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            
            int val = nums[right];
            sum += val;
            map.put(val, map.getOrDefault(val, 0) + 1);

            if (right - left + 1 > k) {

                int value = nums[left];
                map.put(value, map.get(value) - 1);

                if (map.get(value) == 0) map.remove(value);
                sum -= value;
                left++;
            }

            if (right - left + 1 == k && map.size() == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
