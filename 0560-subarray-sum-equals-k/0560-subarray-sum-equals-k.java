class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int prefixSum = 0;
        int count = 0;
        
        HashMap<Integer,Integer> preSumMap = new HashMap<>();
        preSumMap.put(0,1); //inital sum and its count
        
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            if(preSumMap.containsKey(prefixSum-k)){
                count = count + preSumMap.get(prefixSum-k);
            }
            preSumMap.put(prefixSum,preSumMap.getOrDefault(prefixSum,0)+1);
        }

        return count;        
    }
}