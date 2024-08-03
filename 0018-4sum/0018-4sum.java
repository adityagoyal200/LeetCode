class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < n; i++){
            if(i!= 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1; j < n; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                // two pointers
                int k = j+1;
                int l = n-1;
                while(k < l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if(sum > target){
                        l--;
                    } else if(sum < target){
                        k++;
                    } else {
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        result.add(temp); 
                        k++;
                        l--;
                        //skipping duplicates
                        while(k<l && nums[k] ==nums[k-1]){
                            k++;
                        }
                        while(k<l && nums[l] == nums[l+1]){
                            l--;
                        }
                    }
                }
            }
        }



        return result;
    }
}