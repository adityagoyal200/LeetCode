class Solution {
    public int minDifference(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length < 5){
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(4);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int num: nums){
            minHeap.offer(num);
            if (minHeap.size() > 4) {
                minHeap.poll();
            }
            
            maxHeap.offer(num);
            if (maxHeap.size() > 4) {
                maxHeap.poll();
            }
        }
        
        int[] smallest = new int[4];
        int[] largest = new int[4];

        for(int i = 0 , j = 3; i < 4 && j >= 0; i++ , j--){
            smallest[i] = minHeap.poll();
            largest[j] = maxHeap.poll();
        }

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < 4; i++){
            int diff = Math.abs(smallest[i] - largest[i]);
            minDiff = Math.min(minDiff,diff);
        }
        
        return minDiff;
    }
}