class Solution(object):
    def isAnagram(self, s, t):
        if len(s) != len(t):
            return False
        
        count = [0] * 26
        
        for char_s, char_t in zip(s, t):
            count[ord(char_s) - ord('a')] += 1
            count[ord(char_t) - ord('a')] -= 1
        
        for i in count:
            if i != 0:
                return False
        
        return True

        