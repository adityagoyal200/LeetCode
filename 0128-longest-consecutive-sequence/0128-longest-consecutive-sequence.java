class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;

        for (int num : nums) {
            // Start a new sequence if num-1 is not in the set
            if (!set.contains(num - 1)) {
                int currNum = num;
                int curr = 1;

                // Count the length of the sequence
                while (set.contains(currNum + 1)) {
                    currNum++;
                    curr++;
                }

                // Update the longest streak
                longest = Math.max(longest, curr);
            }
        }

        return longest;
    }
}
