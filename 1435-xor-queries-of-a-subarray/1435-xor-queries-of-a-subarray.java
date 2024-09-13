class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        int[] result = new int[queries.length];
        int prefixXor = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            prefixXor ^= arr[i];
            map.put(i, prefixXor);
        }

        int index = 0;
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            if (left == 0) {
                result[index] = map.get(right);
            } else {
                result[index] = map.get(right) ^ map.get(left - 1);
            }
            index++;
        }

        return result;
    }
}
