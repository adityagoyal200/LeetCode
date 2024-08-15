class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (map.get(num) == 0) continue;

            for (int i = 0; i < k; i++) {
                int currentNum = num + i;
                if (map.getOrDefault(currentNum, 0) == 0) {
                    return false;
                }
                map.put(currentNum, map.get(currentNum) - 1);
            }
        }

        return true;
    }
}
