class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(arr == null || arr.length == 0){
            return -1;
        }
        int low  = 0;
        int high = arr.length -1;

        //finding the two nearest indexes of missing numbers

        while(low <= high){
            int mid = low + (high - low)/2;
            int missing = arr[mid] - (mid+1);

            if(missing < k){
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }

        return low+k;
    }
}