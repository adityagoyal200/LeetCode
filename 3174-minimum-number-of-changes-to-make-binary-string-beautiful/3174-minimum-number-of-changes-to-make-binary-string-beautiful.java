class Solution {
    public int minChanges(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int cnt = 0;

        for(int i = 0; i < s.length()-1; i += 2){
            if(s.charAt(i) != s.charAt(i+1)){
                cnt++;
            }
        }

        return cnt;
    }
}