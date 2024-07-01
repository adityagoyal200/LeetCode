class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr == null || arr.length == 0){
            return false;
        }

        int count = 0;
        for(int num: arr){
           count = (num % 2 == 1) ? count +1 : 0;
           if(count == 3){
            return true;
           }
        }

        return false;
    }
}