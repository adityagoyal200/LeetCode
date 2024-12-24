class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] prefixArray = new int[m][n];
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < m;j++){
                if(matrix[j][i] == '0'){
                    sum = 0;
                    prefixArray[j][i] = 0;
                } else {
                    sum++;
                    prefixArray[j][i] = sum;
                }
            }
        }

        int maximal = 0;

        for(int i = 0; i<m; i++){
            int maxArea = findMaxArea(prefixArray,i);
            maximal = Math.max(maximal,maxArea);
        }

        return maximal;
    }
    private int findMaxArea(int[][] arr,int row){
        Stack<Integer> st = new Stack<>();
        int largest = 0;
        int n = arr[0].length;
        for(int col = 0; col < n; col++){
            while(!st.isEmpty() && arr[row][st.peek()] >= arr[row][col]){
                int index = st.pop();
                int pse = (st.isEmpty()) ? -1 : st.peek();
                int width = col-pse-1;
                int height = arr[row][index];
                int area = height*width;
                largest = Math.max(area,largest);
            }
            st.push(col);
        }

        while(!st.isEmpty()){
            int index = st.pop();
            int pse = (st.isEmpty()) ? -1 : st.peek();
            int width = n - pse -1;
            int height = arr[row][index];
            int area = height*width;
            largest = Math.max(area,largest);
        }

        return largest;
    }
}