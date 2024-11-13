class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) {
            return "";
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int cnt = 0;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) cnt++;
            }

            while (cnt == t.length()) {
                if (minLen > right - left + 1) {
                    start = left;
                    minLen = right - left + 1;
                }

                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) cnt--;
                }

                left++;
            }

            right++;
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLen);
    }
}
