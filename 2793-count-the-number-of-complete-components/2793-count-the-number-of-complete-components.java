class Solution {
    private int[] parent;
    private int[] size;

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        Arrays.setAll(parent, i -> i);
        Arrays.fill(size, 1);

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        Map<Integer, Integer> componentSize = new HashMap<>();
        Map<Integer, Integer> edgeCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);
            componentSize.put(root, componentSize.getOrDefault(root, 0) + 1);
        }

        for (int[] edge : edges) {
            int root = find(edge[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0) + 1);
        }

        int completeCount = 0;
        for (int root : componentSize.keySet()) {
            int nodes = componentSize.get(root);
            if (edgeCount.getOrDefault(root, 0) == nodes * (nodes - 1) / 2) {
                completeCount++;
            }
        }

        return completeCount;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }
}