class Solution {
    public String removeOccurrences(String s, String part) {
        char[] stack = new char[s.length()];
        int size = 0, len = part.length();
        char endChar = part.charAt(len - 1);

        for (char c : s.toCharArray()) {
            stack[size++] = c;
            if (c == endChar && size >= len && new String(stack, size - len, len).equals(part)) {
                size -= len;
            }
        }
        
        return new String(stack, 0, size);
    }
}
