class Solution {
    private int MAX = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] minPath = new int[n];
        Arrays.fill(minPath, MAX);
        for(int[] flight : flights) {
            graph.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        Queue<int[]> minHeap = new LinkedList<>();//(a, b) -> a[2] == b[2] ? a[1] - b[1] : a[2] - b[2]);
        minHeap.offer(new int[] {src, 0, -1});

        while(!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int stop = node[0];
            int cost = node[1];
            int numOfStops = node[2];

            if(numOfStops > k) continue;

            for(int[] neighbor : graph.get(stop)) {
                int nextStop = neighbor[0];
                int neighborCost = neighbor[1];

                if(neighborCost + cost <= minPath[nextStop] && numOfStops + 1 <= k) {
                    minPath[nextStop] = neighborCost + cost;
                    minHeap.offer(new int[] {nextStop, minPath[nextStop], numOfStops + 1});
                }
            }

        }

        return minPath[dst] != MAX ? minPath[dst] : -1;
    }
}
