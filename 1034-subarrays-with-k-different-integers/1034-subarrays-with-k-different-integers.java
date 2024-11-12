class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubs(nums,k) - countSubs(nums,k-1);
    }
    private int countSubs(int[] nums,int k){
        if(nums == null || nums.length == 0 || k < 0){
            return 0;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int cnt = 0;
        
        while(right < nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            if(map.size() > k){
                while(map.size() > k){
                    if(map.containsKey(nums[left])){
                        map.put(nums[left],map.get(nums[left])-1);
                    }
                    if(map.get(nums[left]) == 0){
                        map.remove(nums[left]);
                    }

                    left++;
                }
            }

            cnt += (right - left)+1;
            right++;
        }

        return cnt;
    }
}