class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Check if the array is null or empty, return an empty list if so
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        // Create a list to store the disappeared numbers
        List<Integer> list = new ArrayList<>();

        // Mark the indices corresponding to the numbers that are present in the array
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            nums[val] = -Math.abs(nums[val]);
        }

        // Add the indices (plus 1) that are still positive to the result list
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            } else {
                nums[i] = -1 * nums[i];
            }
        }

        // Return the list of disappeared numbers
        return list;
    }
}
