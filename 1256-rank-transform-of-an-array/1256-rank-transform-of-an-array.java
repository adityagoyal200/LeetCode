class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[] {};
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        for (int num : arr) {
            treeMap.put(num, 0);
        }

        int rank = 1;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            entry.setValue(rank++);
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = treeMap.get(arr[i]);
        }

        return result;
    }
}
