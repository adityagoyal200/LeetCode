class Solution {
    List<List<Integer>> result;
    boolean[] used;
    
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        used = new boolean[nums.length];
        
        if(nums == null || nums.length == 0){
            return result;
        }
        
        backtrack(nums,0,new ArrayList<>());

        return result;
    }
        
    public void backtrack(int[] nums, int start, List<Integer> list){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtrack(nums,i+1,list);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
