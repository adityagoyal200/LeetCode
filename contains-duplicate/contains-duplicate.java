class Solution {
   public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicate = new HashSet();
        for (int n : nums) {
            if (!duplicate.add(n)){
                return true;
            }
        }
        return false;
    }
}