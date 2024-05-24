class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
            map.put(num,map.get(num)+1);
        }
        int majority = (nums.length)/2;
        for(int num: map.keySet()){
            if(map.get(num) > majority){
                return num;
            }
        }

        return -1;
    }
}