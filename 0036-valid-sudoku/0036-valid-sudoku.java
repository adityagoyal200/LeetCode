class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[][] subMatrices = new HashSet[3][3];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                subMatrices[i][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];

                if (current == '.') {
                    continue;
                }

                if (rows[i].contains(current)) {
                    return false;
                }
                rows[i].add(current);

                if (cols[j].contains(current)) {
                    return false;
                }

                cols[j].add(current);

                if (subMatrices[i / 3][j / 3].contains(current)) {
                    return false;
                }
                
                subMatrices[i / 3][j / 3].add(current);
            }
        }

        return true;
    }
}
