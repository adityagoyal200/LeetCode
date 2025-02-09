class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        self.cnt = 0
        board = [["."] * n for _ in range(n)]

        def is_safe(row, col):
            for i in range(row):
                if board[i][col] == "Q":
                    return False
            
            i, j = row, col
            while i >= 0 and j >= 0:
                if board[i][j] == "Q":
                    return False
                i -= 1
                j -= 1
            
            i, j = row, col
            while i >= 0 and j < n:
                if board[i][j] == "Q":
                    return False
                i -= 1
                j += 1
            
            return True
        
        def backtrack(row):
            if row == n:
                self.cnt += 1
                return
            
            for col in range(n):
                if is_safe(row, col):
                    board[row][col] = "Q"
                    backtrack(row + 1)
                    board[row][col] = "."  
        
        backtrack(0)
        return self.cnt

        