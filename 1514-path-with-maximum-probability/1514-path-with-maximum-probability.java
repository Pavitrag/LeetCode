class Solution {
    
    private static class Pair {
        int id;
        double weight;

        public Pair(int id, double weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return super.equals(obj);
            }
            if (obj instanceof Pair) {
                Pair other = (Pair) obj;
                return this.id == other.id;
            }
            return false;
        }
    }//:~ Pair
    
    public double shortestPath(List<List<Pair>> adjList, int source, int target) {
        final double INF = 0d;
        double[] probability = new double[adjList.size()];
        for (int i = 0; i < probability.length; i++) {
            probability[i] = INF;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (n1, n2) -> probability[n1.id] >= probability[n2.id] ? -1 : 1);
        probability[source] = 1d;
        Pair sourceNode = new Pair(source, probability[source]);
        pq.add(sourceNode);

        for (int i = 0; i < adjList.size(); i++) {
            if (i != source) {
                pq.add(new Pair(i, probability[i]));
            }
        }

        while (!pq.isEmpty()) {
            Pair currentMinNode = pq.poll();
            if(currentMinNode.id == target){
                break;
            }
            List<Pair> neighbors = adjList.get(currentMinNode.id);
            for (Pair neighbor : neighbors) {
                int index = neighbor.id;
                if (probability[index] < probability[currentMinNode.id] * neighbor.weight) {
                    pq.remove(neighbor); // because PriorityQueue does not allow to change (increase
                                         // key/decrease key)
                    probability[index] = probability[currentMinNode.id] * neighbor.weight;
                    pq.add(new Pair(index, probability[index]));// same reason as for remove call.
                }
            }
        }
        return probability[target];
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adjList = new ArrayList<>();
        IntStream.range(0, n+1).forEach(e -> adjList.add(new ArrayList<>()));

        for (int index = 0; index < edges.length; index++) {
            List<Pair> neighbors = adjList.get(edges[index][0]);
            neighbors.add(new Pair(edges[index][1], succProb[index]));

            neighbors = adjList.get(edges[index][1]);
            neighbors.add(new Pair(edges[index][0], succProb[index]));
        }
        return shortestPath(adjList, start, end);
    }
}