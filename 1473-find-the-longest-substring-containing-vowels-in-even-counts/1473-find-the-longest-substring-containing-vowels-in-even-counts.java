class Solution {
    public int findTheLongestSubstring(String s) {
        int map[] = new int[26];
        map['a' - 'a'] = 1;
        map['e' - 'a'] = 2;
        map['i' - 'a'] = 4;
        map['o' - 'a'] = 8;
        map['u' - 'a'] = 16;

        int longest = 0;
        int prefixXor = 0;
        int xorArr[] = new int[32];

        Arrays.fill(xorArr, -1);

        for (int i = 0; i < s.length(); i++) {
            prefixXor ^= map[s.charAt(i) - 'a'];
            
            if (xorArr[prefixXor] == -1 && prefixXor != 0){
                xorArr[prefixXor] = i;
            }

            longest = Math.max(longest, i - xorArr[prefixXor]);
        }

        return longest;

    }
}