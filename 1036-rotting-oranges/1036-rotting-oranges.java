class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int cnt = countRotten(grid,q);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
 
        return (cnt == 0) ? 0 : cnt-1;
    }
    public int countRotten(int[][] grid, Queue<int[]> q){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; 
        int cnt  = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cell = q.poll(); 
                for(int[] dir: dirs){
                    int newR = cell[0] + dir[0];
                    int newC = cell[1] + dir[1];

                    if(newR >= 0 && newR < m && newC >= 0 && newC < n && grid[newR][newC] == 1){
                        grid[newR][newC] = 2;
                        q.offer(new int[]{newR,newC});
                    }
                }
            }
            cnt++;
        }

        return cnt;
    }
}