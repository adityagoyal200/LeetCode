class Solution(object):
    def firstCompleteIndex(self, arr, mat):
        """
        :type arr: List[int]
        :type mat: List[List[int]]
        :rtype: int
        """
        m, n = len(mat), len(mat[0])
        pos = {mat[i][j]: (i, j) for i in range(m) for j in range(n)}
        row, col = [0] * m, [0] * n
        for i, num in enumerate(arr):
            r, c = pos[num]
            row[r] += 1
            col[c] += 1
            if row[r] == n or col[c] == m:
                return i
        return -1
