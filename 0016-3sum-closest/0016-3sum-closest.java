class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // minimum sum of the array

        for (int i = 0; i < nums.length; i++) { 
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum == target) {
                    return sum;
                }
                
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                // reaching closer to the sum
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return closestSum;
    }
}