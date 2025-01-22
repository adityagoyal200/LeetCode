class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] highestPeak(int[][] isWater) {
        if(isWater == null || isWater.length == 0){
            return isWater;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];

        for(int i = 0; i < isWater.length; i++){
            for(int j = 0; j < isWater[0].length; j++){
                if(isWater[i][j] == 1){
                    isWater[i][j] = 0;
                    visited[i][j] = true;
                    q.offer(new int[]{i,j});
                } else {
                    isWater[i][j] = -1;
                }
            }
        }

        updateMatrix(isWater,visited,q);

        return isWater;
    }
    private void updateMatrix(int[][] grid,boolean[][] visited, Queue<int[]> q){
        int dist  = 1;
        while(!q.isEmpty()){
            int size =  q.size();
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                for(int[] dir: directions){
                    int newR = cell[0] +dir[0];
                    int newC = cell[1] + dir[1];
                    if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && !visited[newR][newC]){
                        grid[newR][newC] = dist;
                        visited[newR][newC] = true;
                        q.offer(new int[]{newR,newC});
                    }
                }
            }

            dist++;  
        }
    }
}