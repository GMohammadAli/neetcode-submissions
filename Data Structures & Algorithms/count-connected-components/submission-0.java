class Solution {
    public int countComponents(int n, int[][] edges) {
        int numOfConnections = 0;

        //1. Create Graph
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //2. Checking connections
        HashSet<Integer> recursionStack = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(!recursionStack.contains(i)) {
                numOfConnections++;
                markAllConnectedComponents(i, graph, recursionStack);
            }
        }

        return numOfConnections;
    }

    public void markAllConnectedComponents(int node, List<List<Integer>> graph, HashSet<Integer> recursionStack) {
        if(recursionStack.contains(node)) return;

        recursionStack.add(node);
        for(Integer neighbor : graph.get(node)) {
            markAllConnectedComponents(neighbor, graph, recursionStack);
        }
    }
}
