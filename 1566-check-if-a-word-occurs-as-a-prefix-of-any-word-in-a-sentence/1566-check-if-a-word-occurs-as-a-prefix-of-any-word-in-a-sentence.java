class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if(sentence == null || sentence.length() == 0){
            return -1;
        }
        
        int cnt = 0;
        int len = searchWord.length();
        String[] words = sentence.split(" ");

        for(String word: words){
            cnt++;
            if(word.length() >= len){
                if(word.substring(0,len).equals(searchWord)){
                    return cnt;
                }
            }
        }

        return -1;
    }
}