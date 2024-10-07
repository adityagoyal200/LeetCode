class Solution {
    public int minLength(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int length = stack.length();
            if (length > 0 &&
                ((stack.charAt(length - 1) == 'A' && c == 'B') || (stack.charAt(length - 1) == 'C' && c == 'D'))) {
                stack.deleteCharAt(length - 1); 
            } else {
                stack.append(c); 
            }
        }

        return stack.length();
    }
}
