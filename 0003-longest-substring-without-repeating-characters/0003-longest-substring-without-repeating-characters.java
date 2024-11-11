class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int maxLen = 1;

        for(int i = 0; i < s.length(); i++){
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int j = i +1;
            for(; j < s.length(); j++){
                if(set.contains(s.charAt(j))){
                    maxLen = Math.max(maxLen,j-i);
                    break;
                }
                set.add(s.charAt(j));
            }
            maxLen = Math.max(maxLen,j-i);
        }

        return maxLen;
    }
}