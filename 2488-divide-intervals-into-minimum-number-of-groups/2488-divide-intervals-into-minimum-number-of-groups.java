class Solution {
    public int minGroups(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int maxGroups = 0;
        int newGroups = 0;
        int i = 0, j = 0;

        while (i < n) {
            if (starts[i] <= ends[j]) {
                newGroups++;
                maxGroups = Math.max(maxGroups, newGroups);
                i++;
            } else {
                newGroups--;
                j++;
            }
        }

        return maxGroups;
    }
}
