class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return 0;
        }

        Arrays.sort(nums);
        int closest = nums[0] + nums[1]+ nums[2];

        for(int i = 0; i < nums.length; i++){
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }

                if(sum < target){
                    j++;
                } else {
                    k--;
                }
            }
        }

        return closest; 
    }
}