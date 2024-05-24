class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int ele = nums[0];
        int count = 1;
        int i = 1;
        while(i < nums.length){
            if(count == 0){
                ele = nums[i];
                count = 1;
            }
            else if(nums[i] == ele){
                count++;
            } else {
                count--;
            }
            i++;
        }
        /**check if ele  is majority*/
        int majority = nums.length /2;
        int cnt = 0;
        for(int j = 0; j< nums.length; j++){
            if(nums[j] == ele){
                cnt++;
            }
        }
        return (cnt > majority) ? ele: -1;
    }
}