class Solution {
    public boolean validTree(int n, int[][] edges) {
        //Edge Case
        if(edges.length != n - 1) return false;
    
        //1. Create Graph (Adjacency List)
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //2. Check if all nodes connected and no cycles
        HashSet<Integer> cycle = new HashSet<>();

        if(!dfs(0, -1, graph, cycle)) {
            return false;
        }

        //all nodes are connected if visited.size() == number of nodes
        return cycle.size() == n;
    }

    public boolean dfs(int vertex, int parent, List<List<Integer>> graph, HashSet<Integer> cycle) {

        cycle.add(vertex);
        
        for(Integer neighbor : graph.get(vertex)) {
            if(neighbor == parent) continue; // skip the edge back to parent
            if(cycle.contains(neighbor)) return false; // cycle detected
            if(!dfs(neighbor, vertex, graph, cycle)) {
                return false;
            }
        }

        return true;
    }
}
