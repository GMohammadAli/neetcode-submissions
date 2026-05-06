class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> cycle = new HashSet<>();
        if(!isAcyclic(graph, 0, -1, cycle)) {
            return false;
        }

        return cycle.size() == n;
    }

    public boolean isAcyclic(List<List<Integer>> graph, int vertex, int parent, HashSet<Integer> cycle) {

        cycle.add(vertex);

        for(int neighbor : graph.get(vertex)) {
            if(neighbor == parent) continue;
            if(cycle.contains(neighbor)) return false;
            if(!isAcyclic(graph, neighbor, vertex, cycle)) {
                return false;
            }
        }

        return true;
    }
}
