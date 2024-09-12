class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();

        helper(nums,used,new ArrayList<>(), result);

        return result;
    }
    private void helper(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;
            list.add(nums[i]);
            used[i] = true;
            helper(nums,used,list,result);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}