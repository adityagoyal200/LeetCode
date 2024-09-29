class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        int n = maximumHeight.length;
        Arrays.sort(maximumHeight);
        
        long sum = 0;
        int lastH= Integer.MAX_VALUE;
        
        for (int i = n - 1; i >= 0; i--) {
            int currH = Math.min(maximumHeight[i], lastH- 1);
            
            if (currH < 1) {
                return -1;
            }
            
            sum += currH;
            lastH= currH;
        }
        
        return sum;
    }
}