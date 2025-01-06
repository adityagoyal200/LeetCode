class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        int count = 0, rightSum = 0;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] += rightSum;
            count += boxes.charAt(i) - '0';
            rightSum += count;
        }
        count = 0;
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            ans[i] += leftSum;
            count += boxes.charAt(i) - '0';
            leftSum += count;
        }
        return ans;
    }
}