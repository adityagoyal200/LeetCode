class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        if (bannedWords == null || bannedWords.length == 0) {
            return false;
        }
        if (message == null || message.length == 0) {
            return false;
        }

        Set<String> set = new HashSet<>();
        for(String s: bannedWords){
            set.add(s);
        }

        int cnt  = 0;
        for(String s: message){
            if(set.contains(s)){
                cnt++;
            }
            if(cnt >= 2){
                return true;
            }
        }

        return false;
    }
}
