class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.trim());

        StringBuilder st = new StringBuilder();
        int i = 0;
        boolean neg = false;

        if (i < sb.length() && sb.charAt(i) == '-') {
            neg = true;
            i++;
        } else if (i < sb.length() && sb.charAt(i) == '+') {
            i++;
        }

        while (i < sb.length() && Character.isDigit(sb.charAt(i))) {
            st.append(sb.charAt(i));
            i++;
        }

        if (st.length() == 0) {
            return 0;
        }

        try {
            int num = Integer.parseInt(st.toString());
            return neg ? -num : num;
        } catch (NumberFormatException e) {
            return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
