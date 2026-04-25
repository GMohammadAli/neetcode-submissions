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
				bfs(i, graph, visiting);
			}
		}
		
		return numOfComponents;
	}
	
	public void bfs(int vertex, List<List<Integer>> graph, boolean[] visiting) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(vertex);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			if(visiting[node]) continue;
			visiting[node] = true;
			for(Integer neighbor : graph.get(node)) {
				queue.offer(neighbor);
			}
		}
	}
}