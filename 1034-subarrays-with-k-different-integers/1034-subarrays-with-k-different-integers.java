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
            int val = nums[right];
            map.put(val,map.getOrDefault(val,0)+1);

            if(map.size() > k){
                while(map.size() > k){
                    int value = nums[left];
                    if(map.containsKey(value)){
                        map.put(value,map.get(value)-1);
                    }
                    if(map.get(value) == 0){
                        map.remove(value);
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