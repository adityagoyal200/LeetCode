class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] result = new int[A.length];

        int[] freq = new int[51];
        int cnt = 0;
        for(int i = 0; i < A.length; i++){
            if(freq[A[i]] != 0){
                cnt++;
            }
            freq[A[i]]++;
            
            if(freq[B[i]] != 0){
                cnt++;
            }
            freq[B[i]]++;
            
            result[i] = cnt;
        }

        return result;
    }
}