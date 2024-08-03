class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == ')') {
                Queue<Character> queue = new LinkedList<>();

                while (!stack.isEmpty() && stack.peek() != '(') {
                    queue.add(stack.pop());
                }
                
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                
                while (!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}
