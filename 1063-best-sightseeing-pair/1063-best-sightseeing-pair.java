class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int prevLargest = values[0];
        int res = values[0] + values[1] - 1;
        
        for (int j = 1; j < values.length; j++) {
            res = Math.max(prevLargest + values[j] - j, res);
            prevLargest = Math.max(values[j] + j, prevLargest);
        }

        return res;
    }
}
