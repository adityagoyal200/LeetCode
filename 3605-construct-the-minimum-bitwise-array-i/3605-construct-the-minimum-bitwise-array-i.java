class Solution { 
    public int[] minBitwiseArray(List<Integer> arr) {
        int[] ans = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            ans[i] = -1;
            for (int possibleAns = 0; possibleAns < num; possibleAns++) {
                if ((possibleAns | (possibleAns + 1)) == num) {
                    ans[i] = possibleAns;
                    break;
                }
            }
        }

        return ans;  
    }
}