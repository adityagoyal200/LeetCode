class Solution {
    public long pickGifts(int[] gifts, int k) {
        if (gifts == null || gifts.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }

        for (int i = 0; i < k; i++) {
            int largest = maxHeap.poll(); 
            maxHeap.offer((int) Math.sqrt(largest)); 
        }

        long sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}
