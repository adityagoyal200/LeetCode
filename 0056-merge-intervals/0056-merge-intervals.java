class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] interval: intervals){
            if(end >= interval[0]){
                end = Math.max(end,interval[1]);
            } else {
                list.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
            }
        }

        list.add(new int[]{start,end});

        return list.toArray(new int[list.size()][]);
    }
}