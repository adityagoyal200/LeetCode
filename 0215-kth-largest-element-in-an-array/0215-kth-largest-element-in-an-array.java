class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k){
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num: nums){
            if(pq.size() < k){
                pq.offer(num);
            } else if(num > pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }

        return pq.peek();
    }
}