class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] xInt = new int[rectangles.length][2];
        int[][] yInt = new int[rectangles.length][2];

        for (int i = 0; i < rectangles.length; i++) {
            xInt[i][0] = rectangles[i][0];
            xInt[i][1] = rectangles[i][2];
            yInt[i][0] = rectangles[i][1];
            yInt[i][1] = rectangles[i][3];
        }

        return check(xInt) || check(yInt);
    }

    private boolean check(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int sections = 0;
        int maxEnd = intervals[0][1];

        for (int[] interval : intervals) {
            if (maxEnd <= interval[0]) {
                sections++;
            }
            maxEnd = Math.max(maxEnd, interval[1]);
        }

        return sections >= 2;
    }
}