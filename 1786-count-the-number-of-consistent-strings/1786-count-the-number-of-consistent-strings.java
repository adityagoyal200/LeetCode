class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        boolean[] allowedSet = new boolean[26];
        for (char c : allowed.toCharArray()) {
            allowedSet[c - 'a'] = true;
        }

        int count = 0;
        for (String s : words) {
            boolean isConsistent = true;
            for (int i = 0; i < s.length(); i++) {
                if (!allowedSet[s.charAt(i) - 'a']) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                count++;
            }
        }

        return count;
    }
}
