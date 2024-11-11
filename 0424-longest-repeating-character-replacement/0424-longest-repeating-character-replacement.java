class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxF = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        while(right < s.length()){
            char c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            maxF = Math.max(maxF,map.get(c));

            if((right-left+1)-maxF > k){
                char curr = s.charAt(left);
                map.put(curr,map.get(curr)-1);
                left++;
            }

            if((right-left+1)-maxF <= k){
                maxLen = Math.max(maxLen,right-left+1);
            }

            right++;
        }

        return maxLen;
    }
}