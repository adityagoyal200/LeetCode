class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length()) return 0;

        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;

        int cnt = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        words.remove(beginWord);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){

                String currWord = q.poll();
                if(currWord.equals(endWord)) return cnt;
                char[] wordArray = currWord.toCharArray();

                for(int j = 0; j < wordArray.length; j++){
                    char orignalChar = wordArray[j];
                    
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == orignalChar) continue;
                        wordArray[j] = c;
                        String nextWord = new String(wordArray);
                        if(words.contains(nextWord)){
                            q.offer(nextWord);
                            words.remove(nextWord);
                        }
                    }

                    wordArray[j] = orignalChar;
                }
            }

            cnt++;
        }

        return 0;
    }
}