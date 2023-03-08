/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order. */

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans= new int [2];
       HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans[1]=i;
                ans[0]=map.get(target-nums[i]);
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }   
}

/*The twoSum function takes an integer array nums and an integer target as inputs and returns an integer array containing the indices of the two numbers that add up to the target. The implementation uses a HashMap to store the previously visited numbers along with their indices. The HashMap allows for a constant-time lookup of the complement of the current number (i.e., target - nums[i]) to see if it has been visited previously. If it has, the function returns the indices of the current number and the complement. */
