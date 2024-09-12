class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }
        
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates,0,0,target,new ArrayList<>(),result);

        return result;
    }
    private void helper(int[] arr, int index, int sum,int target, List<Integer> list, List<List<Integer>> result){
        //base
        if(index == arr.length){
            if(sum == target){
                result.add(new ArrayList<>(list));
                return;
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


        //logic
        

        list.add(arr[index]);
        helper(arr, index+1,sum+arr[index],target,list,result);
        list.remove(list.size()-1);

        while(index+1 < arr.length && arr[index] == arr[index+1]){
            index++;
        }

        helper(arr,index+1,sum,target,list,result);

    }
}