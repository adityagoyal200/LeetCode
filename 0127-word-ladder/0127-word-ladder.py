class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        if len(beginWord) != len(endWord):
            return 0
        
        word_set = set(wordList)

        if endWord not in word_set:
            return 0

        count = self.helper(beginWord, endWord, word_set)

        if count == 0:
            return 0
        
        return count
    
    def helper(self, beginWord, endWord, word_set):
        cnt = 1
        queue = deque([beginWord])
        while queue:
            size = len(queue)
            for i in range(size):
                curr_word = queue.popleft()
                if curr_word == endWord:
                    return cnt
                
                wordArray = list(curr_word)
                for j in range(len(wordArray)):
                    curr_char = wordArray[j]
                    for c in range(ord('a'), ord('z') + 1):
                        if chr(c) == curr_char:
                            continue
                        wordArray[j] = chr(c)
                        new_word = ''.join(wordArray)
                        if new_word in word_set:
                            queue.append(new_word)
                            word_set.remove(new_word)
                    
                    wordArray[j] = curr_char
                
            cnt += 1
        
        return 0


        

        