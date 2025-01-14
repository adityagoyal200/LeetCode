class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] result = new int[A.length];

        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < A.length; i++){
            if(map.containsKey(A[i])){
                cnt++;
            }
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            
            if(map.containsKey(B[i])){
                cnt++;
            }
            map.put(B[i],map.getOrDefault(B[i],0)+1);
            
            result[i] = cnt;
        }

        return result;
    }
}