class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            max = Math.max(max,num);
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int[] dp = new int[max + 1]; 
        for(int i = 0; i <= max; i++){ 
            dp[i] = 0;
            if(map.containsKey(i)){
                dp[i] = map.get(i) * i;
            } 
        }

        int skip = 0, take = dp[0];

        for(int i = 1; i <= max; i++){ 
            int temp = Math.max(skip,take);
            take = skip + dp[i];
            skip = temp;
        }

        return Math.max(skip,take);
    }
}
