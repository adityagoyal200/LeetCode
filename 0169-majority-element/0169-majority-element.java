class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int cnt = 1;
        int i = 1;
        int ele = nums[0];
        int n = nums.length;

        while(i < n){
            if(cnt == 0){
                ele = nums[i];
            }
            if(nums[i] == ele){
                cnt++;
            } else {
                cnt--;
            }

            i++;
        }

        for(i = 0 ; i < n ; i++){
            if(nums[i] == ele){
                cnt++;
            }
        }

        return (cnt > n/2) ? ele : -1;
        
    }
}