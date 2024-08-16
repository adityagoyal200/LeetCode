class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays == null || arrays.size() == 0) {
            return 0;
        }

        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int currentMin = array.get(0);
            int currentMax = array.get(array.size() - 1);

            maxDistance = Math.max(maxDistance, Math.abs(currentMax - min));
            maxDistance = Math.max(maxDistance, Math.abs(max - currentMin));


            min = Math.min(min, currentMin);
            max = Math.max(max, currentMax);
        }

        return maxDistance;
    }
}
