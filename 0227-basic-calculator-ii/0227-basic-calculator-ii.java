class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char lastChar = '+';

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || (i == s.length()-1)){
                if(lastChar == '+'){
                    st.push(num);
                }else  if(lastChar == '-'){
                    st.push(-1 * num);
                } else if(lastChar == '*'){
                    st.push(st.pop() * num);
                } else if(lastChar == '/'){
                    st.push(st.pop()/num);
                }
                num = 0;
                lastChar = c;
            }
        }

        while(!st.isEmpty()){
            ans += st.pop();
        }

        return ans;
    }
}