class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        if (mapping.length == 0 || nums.length == 0) {
            return new int[]{};
        }

        int[] map = new int[10];
        for (int i = 0; i < mapping.length; i++) {
            map[i] = mapping[i];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < nums.length; i++) {
            int val = mapped(nums[i], map);
            pq.offer(new int[]{val, i});
        }

        int[] result = new int[nums.length];
        int index = 0;

        while (!pq.isEmpty()) {
            int[] value = pq.poll();
            result[index++] = nums[value[1]];
        }

        return result;
    }

    private int mapped(int num, int[] map) {
        if (num == 0) {
            return map[0];
        }
        StringBuilder val = new StringBuilder();
        while (num > 0) {
            val.append(map[num % 10]);
            num /= 10;
        }
        return Integer.parseInt(val.reverse().toString());
    }
}

