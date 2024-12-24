class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] prefixArr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == '1') {
                    sum++;
                    prefixArr[j][i] = sum;
                } else {
                    sum = 0;
                    prefixArr[j][i] = sum;
                }
            }
        }

        int largest = 0;

        for (int i = 0; i < matrix.length; i++) {
            int area = findArea(prefixArr, i);
            largest = Math.max(area, largest);
        }

        return largest;
    }

    private int findArea(int[][] arr, int row) {
        Stack<Integer> st = new Stack<>();
        int largest = 0;
        int n = arr[0].length;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[row][st.peek()] >= arr[row][i]) {
                int height = arr[row][st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                largest = Math.max(largest, height * width);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int height = arr[row][st.pop()];
            int width = st.isEmpty() ? n : n - st.peek() - 1;
            largest = Math.max(largest, height * width);
        }

        return largest;
    }
}
