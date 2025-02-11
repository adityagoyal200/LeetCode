class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if not s:
            return []
        
        self.result = []
        self.helper(s, 0, 0, "")
        return self.result

    def helper(self, s, index, dots, curr):
        if index == len(s) and dots == 4:
            self.result.append(curr[:-1])
            return

        if dots > 4 or index >= len(s):
            return

        for i in range(1, 4):
            if index + i <= len(s):
                partition = s[index:index + i]
                value = int(partition)
                if 0 <= value <= 255 and (partition == "0" or partition[0] != '0'):
                    self.helper(s, index + i, dots + 1, curr + partition + ".")

        