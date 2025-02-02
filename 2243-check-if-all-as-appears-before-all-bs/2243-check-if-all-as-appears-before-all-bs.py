class Solution(object):
    def checkString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s is None or len(s) <= 1:
            return True
        
        a_before = True
        b_before = False

        for i in range(len(s)):
            if s[i] == 'a' and b_before:
                return False
            if s[i] == 'b' and b_before == False:
                b_before = True
        
        return True

        