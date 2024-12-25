class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int totalProvinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                totalProvinces++;
                bfs(isConnected, visited, i);
            }
        }

        return totalProvinces;
    }

    private void bfs(int[][] isConnected, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;

            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[curr][j] == 1 && !visited[j]) {
                    queue.offer(j);
                }
            }
        }
    }
}
