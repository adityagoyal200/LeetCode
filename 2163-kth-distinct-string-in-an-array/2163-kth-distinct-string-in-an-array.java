class Solution {
    public String kthDistinct(String[] arr, int k) {
        if(arr == null || arr.length == 0 || k <= 0) {
            return "";
        }

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String s : arr) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        
        int count = 0;
        for (String s : arr) {
            if (frequencyMap.get(s) == 1) {
                count++;
                if (count == k) {
                    return s;
                }
            }
        }

        return "";
    }
}
