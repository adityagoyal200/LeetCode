class Solution {
    public long maxKelements(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int x : nums){
            pq.offer(x);
        }

        long score = 0;
        while (!pq.isEmpty() && k > 0) {
            score += pq.peek();
            int x = (int) Math.ceil(pq.poll() / 3.0);
            pq.add(x);
            k--;
        }
        
        return score;
    }
}