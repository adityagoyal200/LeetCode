class Solution {
    public String makeFancyString(String s) {
        if(s == null || s.length() == 0 || s.length() <= 2){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int cnt  = 1;
        for(char c: s.toCharArray()){
            if(sb.length() == 0){
                sb.append(c);
            } else if(sb.charAt(sb.length()-1) == c){
                cnt++;
                if(cnt >= 3){
                    continue;
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(c);
                cnt = 1;
            }
        }

        return sb.toString();
    }
}