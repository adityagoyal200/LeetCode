class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result  =  new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        helper(nums,0,new ArrayList<>());

        return result;
    }
    private void helper(int[] arr, int index, List<Integer> list){
        if(index >= arr.length){
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[index]);
        helper(arr,index+1,list);

        list.remove(list.size()-1);
        helper(arr,index+1,list);

    }
}