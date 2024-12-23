class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        helper(candidates,0,0,target,new ArrayList<>());

        return result;
    }
    private void helper(int[] arr, int index, int sum , int target, List<Integer> list){
        //base
        if(index == arr.length){
            if(sum == target){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if(sum > target){
            return;
        }

        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }


        list.add(arr[index]);
        helper(arr,index,sum+arr[index],target,list);
        list.remove(list.size()-1);
        helper(arr,index+1,sum,target,list);
    }
}