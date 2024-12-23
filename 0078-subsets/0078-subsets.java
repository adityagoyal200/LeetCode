class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());

        return result;
    }
    private void helper(int[] nums, int index, List<Integer> list){
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        helper(nums,index+1,list);
        list.remove(list.size()-1);
        helper(nums,index+1,list);
    }
}