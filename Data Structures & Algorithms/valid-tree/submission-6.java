class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A valid graph tree is an undirected graph that is both connected 
        // (all nodes are reachable from one another) and acyclic (contains no cycles or loops). 
        // For a graph with nodes to be a valid tree, it must have exactly n - 1
        //  edges. If the graph is disconnected or contains a cycle, it is not a valid tree

        //edge case
        if(edges.length == 0 && n == 1) return true;

        // 1. Check if number of edges are exactly n - 1
        if(edges.length != n - 1) return false;

        HashSet<Integer> vertices = new HashSet<>();

        for(int[] edge: edges) {
            vertices.add(edge[0]);
            vertices.add(edge[1]);
        }

        // 1. Check if number of vertices is n
        if(vertices.size() != n) return false;

        //graph creation
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        //initializing all vertices with empty list
        for(Integer vertex : vertices) {
            adjacencyList.put(vertex, new ArrayList<>());
        }

        //putting actual connections for each vertex of undirected graph
        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visitedNodes = new HashSet<>();

        // 2. Check if graph is connected and acyclic
        for(Integer vertex : vertices) {
            HashSet<Integer> recursionStack = new HashSet<>();
            if(!checkIfConnectedAndAcyclic(vertex, adjacencyList, visitedNodes, recursionStack)) {
                return false;
            }
        }

        return true;
    }

    public boolean checkIfConnectedAndAcyclic(int node, HashMap<Integer, List<Integer>> graph, HashSet<Integer> visitedNodes, HashSet<Integer> recursionStack) {
        
        if(visitedNodes.contains(node) || !graph.containsKey(node)) {
            return true;
        }

        
        if(recursionStack.contains(node)) {
            return false;
        }

        visitedNodes.add(node);

        List<Integer> neighbors = graph.get(node);
        for(Integer neighbor : neighbors) {
            if(!checkIfConnectedAndAcyclic(neighbor, graph, visitedNodes, recursionStack)){
                return false;
            }
        }

        visitedNodes.remove(node);
        recursionStack.add(node);

        return true;
    }
}
