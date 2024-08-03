class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        String[] st = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i = st.length-1; i >= 0; i--){
            sb.append(st[i]);
            if(i != 0){
                sb.append(" ");
            }
        }

        return sb.toString();

    }
}