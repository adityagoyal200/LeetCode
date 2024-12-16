class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (nums == null || nums.length == 0) {
            return nums; 
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });
        }

        for (int i = 0; i < k; i++) {
            int[] currVal = pq.poll(); 
            int index = currVal[1];
            int val = currVal[0];
            pq.offer(new int[] { val * multiplier, index });
        }

        int[] result = new int[nums.length];
        while (!pq.isEmpty()) {
            int[] values = pq.poll();
            result[values[1]] = values[0];
        }

        return result;
    }
}
