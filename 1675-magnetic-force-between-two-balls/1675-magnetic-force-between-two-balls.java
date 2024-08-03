class Solution {
    public int maxDistance(int[] position, int m) {
        if(position == null || position.length < m){
            return -1;
        }

        Arrays.sort(position);
        int n = position.length;

        if(m == 2){
            return position[n-1] - position[0];
        }

        int low = 1;
        int high = Math.abs(position[n-1]-position[0]);

        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(position,mid,m)){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
    private boolean isPossible(int[] arr, int force, int m){
        int balls = 1;
        int lastPosi = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(Math.abs(arr[i] - lastPosi) >= force){
                balls++;
                lastPosi = arr[i];
                if(balls == m) {
                    return true; 
                } 
            } 
        }

        return false;
    }
}