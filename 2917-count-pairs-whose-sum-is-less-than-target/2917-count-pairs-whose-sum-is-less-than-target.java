import java.util.Collections;
import java.util.List;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int i = 0;
        int j = nums.size() - 1;
        int count = 0;

        while (i < j) {
            if (nums.get(i) + nums.get(j) < target) {
                count += (j - i);
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
