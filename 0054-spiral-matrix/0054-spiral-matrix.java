class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return spiral;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n- 1;
        
        while (left <= right && top <= bottom) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;
            
            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;
            
            // Check if there are more rows and columns remaining
            if (top <= bottom) {
                // Traverse bottom row
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if (left <= right) {
                // Traverse left column
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return spiral;
    }
}
