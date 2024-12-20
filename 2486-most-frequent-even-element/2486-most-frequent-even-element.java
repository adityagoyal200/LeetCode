class Solution {
    public int mostFrequentEven(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            if(num % 2 == 0) map.put(num,map.getOrDefault(num,0)+1);
        }

        if(map.size() == 0) return -1;

        List<Integer>[] frequent = new List[nums.length+1];
        for(int key: map.keySet()){
            int val = map.get(key);
            if(frequent[val] == null) frequent[val] = new ArrayList<>();
            frequent[val].add(key);
        }

        for(int i = frequent.length-1; i >=0;i--){
            if(frequent[i] != null){
                List<Integer> list = frequent[i];
                Collections.sort(list);
                return list.get(0);
            }
        }

        return -1;
    }
}