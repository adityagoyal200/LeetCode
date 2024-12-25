class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length()){
            return 0;
        }

        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;

        int count = helper(beginWord,endWord,words);

        return (count == 0) ? 0 : count;
    }
    private int helper(String begin, String end, Set<String> words){
        int cnt = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(begin);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String currWord = q.poll();
                if(currWord.equals(end)) return cnt;
                char[] wordArray = currWord.toCharArray();
                for(int j = 0; j < wordArray.length; j++){
                    char curr = wordArray[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == curr) continue;
                        wordArray[j] = c;
                        String newWord = new String(wordArray);
                        if(words.contains(newWord)){
                            q.offer(newWord);
                            words.remove(newWord);
                        }
                    }

                    wordArray[j] = curr;
                }
            }

            cnt++;
        }

        return 0;
    }
}