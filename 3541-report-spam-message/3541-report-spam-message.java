class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        if (bannedWords == null || bannedWords.length == 0) {
            return false;
        }
        if (message == null || message.length == 0) {
            return false;
        }

        Set<String> set = new HashSet<>(Arrays.asList(bannedWords));

        int cnt  = 0;
        for(String s: message){
            if(set.contains(s)){
                cnt++;
            }
        }

        return (cnt >= 2);
    }
}
