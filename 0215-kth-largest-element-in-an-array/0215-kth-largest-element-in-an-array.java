class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k){
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num: nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}