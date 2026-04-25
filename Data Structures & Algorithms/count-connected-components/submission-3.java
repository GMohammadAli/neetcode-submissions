class Solution {
	public int countComponents(int n, int[][] edges) {
		//1. Create Graph
		List<List<Integer>> graph = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		//2. Count n Mark all connected components
		int numOfComponents = 0;
		boolean[] visiting = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			if(!visiting[i]) {
				numOfComponents++;
				dfs(i, graph, visiting);
			}
		}
		
		return numOfComponents;
	}
	
	public void dfs(int vertex, List<List<Integer>> graph, boolean[] visiting) {
		if(visiting[vertex]) return;
		
		visiting[vertex] = true;
		for(Integer neighbor : graph.get(vertex)) {
				dfs(neighbor, graph, visiting); 
		}
	}
}