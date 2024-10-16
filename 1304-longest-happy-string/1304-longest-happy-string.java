class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        if (a > 0) pq.offer(new int[]{'a', a});
        if (b > 0) pq.offer(new int[]{'b', b});
        if (c > 0) pq.offer(new int[]{'c', c});

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            char ch1 = (char) first[0];
            int cnt1 = first[1];

            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == ch1 && sb.charAt(sb.length() - 2) == ch1) {
                if (pq.isEmpty()) break;

                int[] second = pq.poll();
                char ch2 = (char) second[0];
                int cnt2 = second[1];

                sb.append((char) ch2);
                if (--cnt2 > 0) pq.offer(new int[]{ch2,cnt2});
                pq.offer(first);
            } else {
                sb.append(ch1);
                if (--cnt1 > 0) pq.offer(new int[]{ch1, cnt1});
            }
        }

        return sb.toString();
    }
}
