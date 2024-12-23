class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int cnt = rottOranges(grid,q);

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return cnt == 0 ? 0 : cnt - 1;
    }
    private int rottOranges(int[][] grid,Queue<int[]> q){
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int cnt = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                for(int[] dir: dirs){
                    int newR = dir[0] + cell[0];
                    int newC = dir[1] + cell[1];
                    if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length 
                    && grid[newR][newC] == 1){
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