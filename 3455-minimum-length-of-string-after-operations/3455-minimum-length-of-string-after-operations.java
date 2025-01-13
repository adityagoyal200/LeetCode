class Solution {
    public int minimumLength(String s) {
        if (s == null || s.length() == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int len = s.length();
        for (int count : map.values()) {
            if (count >= 3) {
                len -= (count % 2 == 1) ? count-1 : count-2;
            }
        }

        return len;
    }
}
