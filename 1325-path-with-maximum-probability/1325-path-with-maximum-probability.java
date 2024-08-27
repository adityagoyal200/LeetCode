class Solution {

    static class Pair {
        int node;
        double prob;

        Pair(int n, double p) {
            this.node = n;
            this.prob = p;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        pq.offer(new Pair(start, 1.0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            double prob = current.prob;

            if (node == end) {
                return prob;
            }

            for (Pair neighbor : adj.get(node)) {
                double newProb = prob * neighbor.prob;
                if (newProb > maxProb[neighbor.node]) {
                    maxProb[neighbor.node] = newProb;
                    pq.offer(new Pair(neighbor.node, newProb));
                }
            }
        }

        return 0.0;
    }
}
