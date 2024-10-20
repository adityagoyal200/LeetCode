import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefixArray = new int[m][n];

        // Build prefix array
        for (int i = 0; i < n; i++) {
            int prefixSum = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] == '0') {
                    prefixSum = 0;
                    prefixArray[j][i] = prefixSum;
                } else {
                    prefixSum += 1;  
                    prefixArray[j][i] = prefixSum;
                }
            }
        }

        int maxRect = 0;

        for (int i = 0; i < m; i++) {
            int area = findArea(prefixArray, i);
            maxRect = Math.max(area, maxRect);
        }

        return maxRect;
    }

    private int findArea(int[][] matrix, int row) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int col = matrix[0].length;

        for (int colIndex = 0; colIndex < col; colIndex++) {
            while (!st.isEmpty() && matrix[row][st.peek()] > matrix[row][colIndex]) {
                int index = st.pop();
                int pse = (st.isEmpty()) ? -1 : st.peek();
                int width = colIndex - pse - 1;
                int height = matrix[row][index];
                int area = height * width;
                maxArea = Math.max(area, maxArea);
            }
            
            st.push(colIndex);
        }

        while (!st.isEmpty()) {
            int index = st.pop();
            int pse = (st.isEmpty()) ? -1 : st.peek();
            int width = col - pse - 1;
            int height = matrix[row][index];
            int area = height * width;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
