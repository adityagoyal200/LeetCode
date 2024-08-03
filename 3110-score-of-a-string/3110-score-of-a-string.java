class Solution {
    public int scoreOfString(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int score = 0;

        for(int i = 1; i<s.length(); i++){
            score += Math.abs((int)s.charAt(i-1) - (int)s.charAt(i));
        }

        return score;
    }
}