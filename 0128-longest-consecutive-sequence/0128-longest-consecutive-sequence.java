class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int longest = 1;

        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            if(!set.contains(num-1)){
                int cnt=1;
                int x = num;
                
                while(set.contains(x+1)){
                    x+=1;
                    cnt+=1;
                }

                longest = Math.max(longest,cnt);
            }
        }
        
        return longest;
    }
}