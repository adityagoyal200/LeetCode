class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer>[] freqArr = new List[nums.length+1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(freqArr[freq] == null) freqArr[freq] = new ArrayList<>();
            freqArr[freq].add(key);
        }

        int[] result = new int[k];
        int index = 0;
        for(int i =  freqArr.length - 1; i >= 0 && k > 0; i--){
            if(freqArr[i] != null){
                List<Integer> temp = freqArr[i];
                for(int num: temp){
                    result[index++] = num;
                    k--;
                    if(k == 0) break;
                }
            }
        }

        return result;
    }
}