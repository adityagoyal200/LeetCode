class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true; 
        }

        Stack<Character> st = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                st.push(current);
            } else if (!st.isEmpty() &&
                    ((current == ')' && st.peek() == '(') ||
                            (current == ']' && st.peek() == '[') ||
                            (current == '}' && st.peek() == '{'))) {
                st.pop();
            } else {
                return false;
            }

            i++;
        }

        return st.isEmpty();
    }
}
