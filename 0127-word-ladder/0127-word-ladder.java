class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length()){
            return 0;
        }

        Set<String> set = new HashSet<>();

        for(String words: wordList){
            set.add(words);
        }

        if(!set.contains(endWord)){
            return 0;
        }

        int length = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            length++;
            for(int i = 0; i < size; i++){
                String s = q.poll();
                if(s.equals(endWord)){
                    return length;
                }
                char[] word = s.toCharArray();
                for(int j = 0; j < word.length; j++){
                    char index = word[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == index)  continue;
                        word[j] = c;
                        String currWord = new String(word);
                        if(set.contains(currWord)){
                            q.offer(currWord);
                            set.remove(currWord);
                        }
                    }

                    word[j] = index;
                }
            }
        }

        return 0;        
    }
}