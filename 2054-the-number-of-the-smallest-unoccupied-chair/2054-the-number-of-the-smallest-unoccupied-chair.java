class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        if (times == null || times.length == 0) {
            return -1;
        }

        int n = times.length;
        TreeSet<Integer> availChair = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            availChair.add(i);
        }

        PriorityQueue<int[]> occChair = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int targetArrival = times[targetFriend][0];

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < times.length; i++) {
            int arr = times[i][0];
            int leave = times[i][1];

            while (!occChair.isEmpty() && occChair.peek()[0] <= arr) {
                availChair.add(occChair.poll()[1]);
            }

            int currAvailChair = availChair.pollFirst();

            if (arr == targetArrival) {
                return currAvailChair;
            }

            occChair.offer(new int[]{leave, currAvailChair});
        }

        return -1;
    }
}

