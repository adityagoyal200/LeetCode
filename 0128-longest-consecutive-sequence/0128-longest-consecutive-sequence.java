class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int longest = 1;
        for(int i = 0; i < nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int curr = 1;
                int currNum = nums[i];
                while(set.contains(currNum+1)){
                    currNum++;
                    curr++;
                }
                longest = Math.max(longest,curr);
            }
        }
        
        return longest;
    }   
}