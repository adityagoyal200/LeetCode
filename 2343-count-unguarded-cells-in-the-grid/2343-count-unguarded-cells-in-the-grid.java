class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] prison = new int[m][n];

        for (int[] wall : walls) {
            prison[wall[0]][wall[1]] = 2;
        }

        for (int[] guard : guards) {
            prison[guard[0]][guard[1]] = 3;
        }

        for (int[] guard : guards) {
            int r = guard[0], c = guard[1];

            for (int i = r + 1; i < m && prison[i][c] != 2 && prison[i][c] != 3; i++) {
                prison[i][c] = 1;
            }

            for (int i = r - 1; i >= 0 && prison[i][c] != 2 && prison[i][c] != 3; i--) {
                prison[i][c] = 1;
            }

            for (int i = c + 1; i < n && prison[r][i] != 2 && prison[r][i] != 3; i++) {
                prison[r][i] = 1;
            }

            for (int i = c - 1; i >= 0 && prison[r][i] != 2 && prison[r][i] != 3; i--) {
                prison[r][i] = 1;
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (prison[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
