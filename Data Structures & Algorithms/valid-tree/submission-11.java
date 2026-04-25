class Solution {
    public boolean validTree(int n, int[][] edges) {
        //Edge Case
        if(edges.length != n - 1) return false;

        //1. Create Graph(Adjacency List)
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1});
        HashSet<Integer> cycle = new HashSet<>();

        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            int vertex = pair[0];
            int parent = pair[1];

            cycle.add(vertex);
            for(Integer neighbor : graph.get(vertex)) {
                if(neighbor == parent) continue;
                if(cycle.contains(neighbor)) return false;
                queue.offer(new int[]{neighbor, vertex});
            }
        }

        return cycle.size() == n;
    }
}
