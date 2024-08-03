class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }

        Arrays.sort(intervals,(a,b) ->a[0] -b[0]);
        List<int[]> ans = new ArrayList<>();

        int start =  intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1],end);
            } else {
                ans.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start,end});

        return ans.toArray(new int[ans.size()][]);
    }
}