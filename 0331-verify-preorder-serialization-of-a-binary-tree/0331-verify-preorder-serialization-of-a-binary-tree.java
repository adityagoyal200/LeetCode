class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }

        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();

        for (String node : nodes) {
            while (node.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop(); // Pop the current '#' and its preceding number
                if (stack.isEmpty()) {
                    return false; // Invalid serialization
                }
                stack.pop(); // Pop the parent node (a number)
            }
            stack.push(node); // Push the current node onto the stack
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}

