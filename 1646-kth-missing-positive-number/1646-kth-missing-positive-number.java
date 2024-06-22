class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(arr == null || arr.length == 0){
            return -1;
        }
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num: arr){
            set.add(num);
            max = Math.max(max, num);
        }

        int miss = 0;
        for(int i = 1; i<= max; i++){
            if(!set.contains(i)){
                miss++;
            }
            if(miss == k){
                return i;
            }
        }

        return max + (k-miss);
        
    }
}