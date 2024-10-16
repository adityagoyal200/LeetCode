class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(
            (Pair<Character, Integer> p1, Pair<Character, Integer> p2) -> p2.getValue() - p1.getValue()
        );

        if (a > 0) pq.offer(new Pair<>('a', a));
        if (b > 0) pq.offer(new Pair<>('b', b));
        if (c > 0) pq.offer(new Pair<>('c', c));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair<Character, Integer> first = pq.poll();
            char ch1 = first.getKey();
            int cnt1 = first.getValue();

            int length = sb.length();

            if (length >= 2 && sb.charAt(length - 1) == ch1 && sb.charAt(length - 2) == ch1) {
                if (pq.isEmpty()) break;

                Pair<Character, Integer> second = pq.poll();
                char ch2 = second.getKey();
                int cnt2 = second.getValue();

                sb.append(ch2);
                cnt2--;

                if (cnt2 > 0) pq.offer(new Pair<>(ch2, cnt2));

                pq.offer(new Pair<>(ch1, cnt1));
            } else {
                sb.append(ch1);
                cnt1--;
                if (cnt1 > 0){
                    pq.offer(new Pair<>(ch1, cnt1));
                }
            }
        }

        return sb.toString();
    }
}
