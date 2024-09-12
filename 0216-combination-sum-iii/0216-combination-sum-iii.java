class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n == 0 || k == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(k,1,n,new ArrayList<>(),result);

        return result;
    }
    private void helper(int size,int start, int target, List<Integer> list, List<List<Integer>> result){
        //base
        if(list.size() == size){
            if(target == 0){
                result.add(new ArrayList<>(list));
                return;
            }
        }

        //logic
        for(int i = start; i<= 9; i++){
            if(i > target){
                break;
            }

            list.add(i);
            helper(size,i+1,target-i,list,result);
            list.remove(list.size()-1);
        }

    }
}