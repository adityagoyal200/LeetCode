class Solution {
	List<List<Integer>> result;
	int sum;
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
   	 	sum = 0;
		result = new ArrayList<>();
        
		if(candidates == null || candidates.length == 0){
	        return result;
        }

        Arrays.sort(candidates);
        backtrack(candidates,0,sum,target,new ArrayList<>());

        return result;
	}
	public void backtrack(int[] nums, int index, int sum, int target, List<Integer> list){
	//base
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        //logic
        for(int i = index; i < nums.length;i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            if(sum + nums[i] <= target){
                sum+=nums[i];
                list.add(nums[i]);
                backtrack(nums,i+1,sum,target,list);
                sum-=nums[i];
                list.remove(list.size()-1);
            }
        }
    }
}