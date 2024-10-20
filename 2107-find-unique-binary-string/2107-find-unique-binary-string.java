class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        
        // Use diagonal flipping to ensure uniqueness
        for (int i = 0; i < nums.length; i++) {
            // Flip the ith bit of the ith string
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        
        return sb.toString();
    }
}
