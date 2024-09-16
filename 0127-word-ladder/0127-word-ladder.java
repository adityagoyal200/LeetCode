import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) {
            return 0;
        }

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        int length = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                if (currentWord.equals(endWord)) {
                    return length;
                }

                char[] wordArray = currentWord.toCharArray();
                for (int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar)
                            continue;
                        wordArray[j] = c;
                        String nextWord = new String(wordArray);
                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                    wordArray[j] = originalChar;
                }
            }
            length++;
        }

        return 0;
    }
}
