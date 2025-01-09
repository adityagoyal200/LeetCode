class Solution {
    public int prefixCount(String[] words, String pref) {
        if(words == null || words.length == 0){
            return 0;
        }

        int cnt  = 0;

        for(String s: words){
            if(s.length() >= pref.length() && s.substring(0,pref.length()).equals(pref)){
                cnt++;
            }
        }

        return cnt;
    }
}