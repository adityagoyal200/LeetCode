class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int complement = -(num3 + num4);
                if (map.containsKey(complement)) {
                    count += map.get(complement);
                }
            }
        }

        return count;
    }
}
