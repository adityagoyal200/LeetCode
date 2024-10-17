class Solution {
    public int maximumSwap(int num) {
        char[] s = Integer.toString(num).toCharArray();
        for (int i = 0; i < s.length; i++) {
            int index = i;
            for (int j = s.length - 1; j > i; j--) {
                if (s[index] < s[j]) {
                    index = j;
                }
            }

            if (index != i && s[i] < s[index]) {
                char temp = s[i];
                s[i] = s[index];
                s[index] = temp;
                return Integer.parseInt(new String(s));
            }
        }

        return num;
    }
}