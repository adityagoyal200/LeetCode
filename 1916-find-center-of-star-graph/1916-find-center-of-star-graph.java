class Solution {
    public int findCenter(int[][] edges) {
        // Check if the first node of the first edge is the same as either node in the second edge
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        // Otherwise, the second node of the first edge must be the center
        return edges[0][1];
    }
}
