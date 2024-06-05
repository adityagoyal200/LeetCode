class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> quad = new HashSet<>();

        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                HashSet<Long> set = new HashSet<>();
                for(int k = j+1; k<n; k++){
                    long sum = nums[i]+nums[j];
                    sum+= nums[k];
                    long rem = target - sum;
                    if(set.contains(rem)){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],(int)rem);
                        Collections.sort(temp);
                        quad.add(temp);
                    } else {
                        set.add((long)nums[k]);
                    }
                }
            }
        }
        for(List<Integer> list: quad){
            result.add(list);
        }

        return result;
    }
}