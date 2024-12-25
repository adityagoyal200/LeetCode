class Solution {
    public int getLargestOutlier(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        long totalSum = 0;
        for(int num: nums) {
            totalSum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int outlier = Integer.MIN_VALUE;

        for(int num: nums) {
            long required = totalSum - num;

            if (required % 2 != 0) continue;
            long value = required/2;
            map.put(num,map.get(num)-1);
            int cnt = map.getOrDefault((int)value,0);
            if(cnt > 0) outlier = Math.max(num,outlier);
            map.put(num,map.get(num)+1);
        }

        return outlier;
    }
}
