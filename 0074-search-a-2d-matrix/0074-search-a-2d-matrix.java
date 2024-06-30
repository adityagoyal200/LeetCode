class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] <= target && matrix[i][colLen-1] >= target){
                return binarySearch(matrix,i,target,0,colLen-1);
            }
        }

        return false;
    }
    private boolean binarySearch(int[][] matrix, int row, int target,int start, int end){
        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(matrix[row][mid] == target){
                return true;
            } else if(matrix[row][mid] < target){
                start = mid+1;  
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}