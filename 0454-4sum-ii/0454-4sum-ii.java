class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                count += map.getOrDefault(-num3-num4, 0);
            }
        }
        
        return count;
    }
}