class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        map.put(0,0);

        for (int i = 0; i < n; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (sum == 0) {
                len = i + 1;
            } else if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return len;
    }
}