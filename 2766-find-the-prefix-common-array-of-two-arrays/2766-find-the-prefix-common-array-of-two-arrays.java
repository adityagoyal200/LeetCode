class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] result = new int[A.length];
        boolean[] seen = new boolean[51];
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (seen[A[i]]) count++;
            seen[A[i]] = true;

            if (seen[B[i]]) count++;
            seen[B[i]] = true;

            result[i] = count;
        }

        return result;
    }
}