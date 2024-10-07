class Solution {
    public int minLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();

        return helper(s, sb, true);
    }

    private int helper(String s, StringBuilder sb, boolean canRemove) {
        if (!canRemove) {
            return s.length();
        }

        int i = 0;
        canRemove = false;
        while (i < s.length()) {
            if (i + 1 < s.length() && ((s.charAt(i) == 'A' && s.charAt(i + 1) == 'B') || (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D'))) {
                i += 2;
                canRemove = true;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        s = sb.toString();
        sb = new StringBuilder();
        return helper(s, sb, canRemove); 
    }
}
