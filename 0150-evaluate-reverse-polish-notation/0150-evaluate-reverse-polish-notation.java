class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> st = new Stack<>();
        int i = 0;
        while (i < tokens.length) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")) {
                int op2 = st.pop();
                int op1 = st.pop();
                int val = tokens[i].equals("+") ? op1 + op2
                        : tokens[i].equals("-") ? op1 - op2
                                : tokens[i].equals("*") ? op1 * op2 : tokens[i].equals("/") ? op1 / op2 : 0;
                st.push(val);
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
            
            i++;
        }

        return st.pop();
    }
}
