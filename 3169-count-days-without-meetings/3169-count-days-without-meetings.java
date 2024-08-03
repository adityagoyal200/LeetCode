class Solution {
    public int countDays(int days, int[][] meetings) {
          if (days == 0) {
            return 0;
        }

        if (meetings.length == 0) {
            return days;
        }

        Arrays.sort(meetings,(a,b)-> a[0] -b[0]);

        int start = meetings[0][0];
        int end = meetings[0][1];
        int count = 0;

        if(start != 1){
            count += start-1;
        }

        for(int i =1 ; i< meetings.length; i++){
            if(meetings[i][0] <= end){
                end = Math.max(end, meetings[i][1]);
            } else {
                count += meetings[i][0] - end - 1;
                start = meetings[i][0];
                end = meetings[i][1];
            }
        }

        if(days > end){
            count += days - end;
        }

        return count;
    }
}
