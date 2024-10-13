class Solution {
    public int minGroups(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int count = 0;

        for(int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];

            if(!pq.isEmpty()){
                if(start > pq.peek()){
                    pq.poll();
                    pq.offer(end);
                } else {
                    count++;
                    pq.offer(end);
                }
            } else {
                count++;
                pq.offer(end);
            }
        }

        return count;
    }
}