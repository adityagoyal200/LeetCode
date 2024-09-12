class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums,used,new ArrayList<>(),result);

        return result;
    }
    private void helper(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result){
        //base
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(nums,used,list,result);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}