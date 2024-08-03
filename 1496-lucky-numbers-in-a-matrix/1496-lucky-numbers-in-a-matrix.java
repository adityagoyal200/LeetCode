class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new ArrayList<>();
        }
        
        List<Integer> lucky = new ArrayList<>();
        int currMin;
        int index;

        for(int j = 0; j < matrix.length; j++){
            currMin = Integer.MAX_VALUE;
            index = 0;
            
            for(int i = 0; i < matrix[0].length; i++){
                if(currMin > matrix[j][i]){
                    currMin = matrix[j][i];
                    index = i;
                }
            }

            if(check(matrix, j, index)){
                lucky.add(matrix[j][index]);
            }
        }

        return lucky;
    }

    private boolean check(int[][] matrix, int row, int col){
        int max = matrix[row][col];
        
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][col] > max){
                return false;
            }
        }

        return true;
    }
}
