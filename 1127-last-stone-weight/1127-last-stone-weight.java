class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        // Max-heap to store the stones
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : stones) {
            pq.offer(num);
        }

        if (pq.size() == 1) return pq.poll();

        while (pq.size() > 1) {
            int stone1 = pq.poll(); 
            int stone2 = pq.poll(); 
            if (stone1 > stone2) {
                pq.offer(stone1 - stone2); 
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
