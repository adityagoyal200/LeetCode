class Solution {
    public int numTrees(int n) {
        int[] binTree = new int[n + 1];
        binTree[0] = binTree[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                binTree[i] += binTree[j - 1] * binTree[i - j];
            }
        }

        return binTree[n];
    }
}