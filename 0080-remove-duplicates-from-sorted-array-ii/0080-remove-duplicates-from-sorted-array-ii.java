class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int cnt = 1;
        
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                if (cnt < 2) {
                    i++;
                    nums[i] = nums[j];
                    cnt++;
                }
            } else {
                i++;
                nums[i] = nums[j];
                cnt = 1;
            }
        }
        
        return i + 1;
    }
}
