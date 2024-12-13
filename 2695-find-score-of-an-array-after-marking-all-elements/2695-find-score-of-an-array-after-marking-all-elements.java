class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] sortedNums = new int[n][2];

        for (int i = 0; i < n; i++) {
            sortedNums[i][0] = nums[i];
            sortedNums[i][1] = i;
        }

        Arrays.sort(sortedNums, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        Set<Integer> visited = new HashSet<>();
        long score = 0;

        for (int[] val : sortedNums) {
            int num = val[0];
            int idx = val[1];

            if (!visited.contains(idx)) {
                score += num;
                visited.add(idx);
                if (idx - 1 >= 0) visited.add(idx - 1);
                if (idx + 1 < n) visited.add(idx + 1);
            }
        }

        return score;
    }
}
