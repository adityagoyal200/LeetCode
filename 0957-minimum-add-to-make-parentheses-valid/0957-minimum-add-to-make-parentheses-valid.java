class Solution {
    public int minAddToMakeValid(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Character> st = new Stack();

        for(int i = 0; i < s.length(); i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            } else {
                if((st.peek() == '(') && (s.charAt(i) == ')')){
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            }
        }

        return st.size();
    }
}