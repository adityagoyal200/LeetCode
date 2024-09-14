class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false;
        }

        

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board,i,j,0,word)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    private boolean helper(char[][] board,int row, int col, int index, String word){
        //base
        if(index == word.length()){
            return true;
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)){
            return false;
        }
        
        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = helper(board,row+1,col,index+1,word)
                        || helper(board,row-1,col,index+1,word) 
                        || helper(board,row,col+1,index+1,word)
                        || helper(board,row,col-1,index+1,word);

        board[row][col] = temp;

        return found;
    }
}