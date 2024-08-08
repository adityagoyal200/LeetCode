class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i-1] == nums[i]){
                continue;
            }

            for(int j = i+1; j < nums.length; j++){
               if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int k  = j+1;
                int l = nums.length-1;

                while(k < l){
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if(sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1]){
                            k++;
                        }
                        while(k<l && nums[l] == nums[l+1]){
                            l--;
                        }
                    } else if(sum < target){
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return result;
    }
}