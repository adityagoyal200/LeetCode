class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        if (times == null || times.length == 0) {
            return -1;
        }

        PriorityQueue<Integer> availChair = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            availChair.add(i);
        }

        int arrivalTarget = times[targetFriend][0];

        PriorityQueue<int[]> occChair = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        for (int[] arrival : times) {
            int arr = arrival[0];
            int left = arrival[1];

            while (!occChair.isEmpty() && occChair.peek()[0] <= arr) {
                int newlyAvail = occChair.poll()[1];
                availChair.offer(newlyAvail);
            }

            if (arr == arrivalTarget) {
                return availChair.peek();
            }

            int currAvailChair = availChair.poll();
            occChair.offer(new int[]{left, currAvailChair});
        }

        return -1;
    }
}
