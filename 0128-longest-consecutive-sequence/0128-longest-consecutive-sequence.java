class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int longest = -1;
        int cnt  = 1;
        
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i]-1)){
                int j = 1;
                while(set.contains(nums[i]+j)){
                    cnt++;
                    j++;
                }
                if(cnt > longest){
                    longest = cnt;
                }
            }
            cnt = 1;
        }

        return longest;
    }
}