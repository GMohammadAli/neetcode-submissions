class Solution {
    public int countComponents(int n, int[][] edges) {
        //Adjacency List
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int numOfConnectedComponents = 0;
        HashSet<Integer> visited = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            if(visited.contains(i)) continue;
            numOfConnectedComponents++;
            dfs(graph, i, visited);
        }

        return numOfConnectedComponents;
    }

    public void dfs(List<List<Integer>> graph, int vertex, HashSet<Integer> visited) {
        if(visited.contains(vertex)) return;

        visited.add(vertex);

        for(int neighbor : graph.get(vertex)) {
            dfs(graph, neighbor, visited);
        }
    }
}
