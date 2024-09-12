class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<>(),result);

        return result;
    }
    private void helper(int[] arr, int index, List<Integer> list , List<List<Integer>> result){
        //base
        if(index == arr.length){
            result.add(new ArrayList<>(list));
            return;
        }


        //logic
        list.add(arr[index]);
        helper(arr,index+1,list,result);
        list.remove(list.size()-1);

        while(index+1 < arr.length && arr[index] == arr[index+1]){
            index++;
        }

        helper(arr,index+1,list,result);
    }
}