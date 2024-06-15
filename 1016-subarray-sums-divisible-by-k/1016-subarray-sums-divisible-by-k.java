import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with 0 remainder having one count
        int sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;
            int remainder = sum % k;
            
            if (remainder < 0) {
                remainder += k;
            }
            
            if (map.containsKey(remainder)) {
                count += map.get(remainder); 
            }
            
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}
