class Solution {
    public int maximumGain(String s, int x, int y) {
        if (s.length() == 0) {
            return 0;
        }

        int score = 0;
        StringBuilder sb = new StringBuilder(s);

        if (x > y) {
            score += helper(sb, "ab", x);
            score += helper(sb, "ba", y);
        } else {
            score += helper(sb, "ba", y);
            score += helper(sb, "ab", x);
        }

        return score;
    }

    private int helper(StringBuilder sb, String pattern, int points) {
        Stack<Character> stack = new Stack<>();
        int score = 0;

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (!stack.isEmpty() && stack.peek() == pattern.charAt(0) 
            && c == pattern.charAt(1)) {
                stack.pop();
                score += points;
            } else {
                stack.push(c);
            }
        }

        sb.setLength(0); 
        for (char c : stack) {
            sb.append(c);
        }

        return score;
    }
}

