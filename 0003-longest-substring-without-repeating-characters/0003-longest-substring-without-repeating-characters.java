class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        int[] charArray = new int[256]; 
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (charArray[c] != 0) {
                while (left < right && s.charAt(left) != c) {
                    charArray[s.charAt(left)]--;
                    left++;
                }
                charArray[s.charAt(left)]--;
                left++;
            }

            charArray[c]++;
            right++;

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}

