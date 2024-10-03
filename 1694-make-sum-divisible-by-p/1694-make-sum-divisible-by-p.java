class Solution {
    public int minSubarray(int[] nums, int p) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int rem = (int)(totalSum % p);
        if (rem == 0) return 0; 

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 
        long sum = 0;
        int len = nums.length;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            int currRem = (int)(sum % p);
            int target = (currRem - rem + p) % p;

            if (map.containsKey(target)) {
                len = Math.min(len, i - map.get(target));
            }

            map.put(currRem, i);
        }

        return (len == nums.length) ? -1 : len;
    }
}