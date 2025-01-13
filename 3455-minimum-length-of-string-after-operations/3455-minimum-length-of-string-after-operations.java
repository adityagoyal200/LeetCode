class Solution {
    public int minimumLength(String s) {
        if (s == null || s.isEmpty()) return 0;

        int[] freq = new int[26]; 
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int len = s.length();
        for (int count : freq) {
            if (count >= 3) {
                len -= (count % 2 == 1) ? count - 1 : count - 2;
            }
        }

        return len;
    }
}
