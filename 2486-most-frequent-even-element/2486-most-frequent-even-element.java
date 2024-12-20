class Solution {
    public int mostFrequentEven(int[] nums) {
        int result = -1,maxFreq = 0;
        Map<Integer, Integer> fMap = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                int freq = fMap.getOrDefault(num, 0) + 1;
                fMap.put(num, freq);

                if (freq > maxFreq || (freq == maxFreq && num < result)) {
                   maxFreq = freq;
                    result = num;
                }
            }
        }

        return result;
    }
}
