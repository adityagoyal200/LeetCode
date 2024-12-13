import java.util.*;

class Solution {
    public long findScore(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> 
            a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        long score = 0;
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && set.contains(pq.peek()[1])) {
                pq.poll();
            }
            if (pq.isEmpty()) break;

            int[] val = pq.poll();
            score += val[0];
            int idx = val[1];

            if (idx - 1 >= 0) set.add(idx - 1);
            if (idx + 1 < nums.length) set.add(idx + 1);
        }

        return score;
    }
}
