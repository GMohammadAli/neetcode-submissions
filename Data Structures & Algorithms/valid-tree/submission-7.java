class Solution {
    public boolean validTree(int n, int[][] edges) {
        //Edge Case
        if(edges.length == 0 && n > 1) return false;

        if(edges.length > n - 1) return false;
    
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
        HashSet<Integer> visited = new HashSet<>();

        if(!dfs(0, graph, cycle, visited)) {
            return false;
        }

        //all nodes are connected if visited.size() == number of nodes
        return visited.size() == n;
    }

    public boolean dfs(int vertex, List<List<Integer>> graph, HashSet<Integer> cycle, HashSet<Integer> visited) {
        if(cycle.contains(vertex)) {
            return false;
        }

        if(visited.contains(vertex)) {
            return true;
        }

        cycle.add(vertex);
        
        System.out.println("vertex "+vertex);
        for(Integer neighbor : graph.get(vertex)) {
            System.out.println("neighbor "+neighbor);
            //it is undirected graph, hence we need to check only non parent nodes
            //is causing a cycle or not
            if(cycle.contains(neighbor)) continue;
            if(!dfs(neighbor, graph, cycle, visited)) {
                return false;
            }
        }
        cycle.remove(vertex);
        visited.add(vertex);

        return true;
    }
}
