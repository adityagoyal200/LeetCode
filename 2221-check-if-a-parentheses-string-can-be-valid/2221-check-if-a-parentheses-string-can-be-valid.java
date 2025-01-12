class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;

        int open = 0, close = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                open++;
            } else {
                open--;
            }

            if (open < 0) return false;

            int j = n - 1 - i;
            if (s.charAt(j) == ')' || locked.charAt(j) == '0') {
                close++;
            } else {
                close--;
            }

            if (close < 0) return false;
        }

        return true;
    }
}

