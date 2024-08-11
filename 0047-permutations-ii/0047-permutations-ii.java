class Solution {
    List<List<Integer>> result;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> list) {

        // base
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // logic
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            list.add(nums[i]);

            used[i] = true;
            backtrack(nums, i + 1, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}