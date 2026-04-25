class Solution {
	public int countComponents(int n, int[][] edges) {
		//initialize parent and rank arrays
		int[] parent = new int[n];
		int[] rank = new int[n];
		
		//set initial values for parent and rank
		for(int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		//union and connect all possible edges
		int result = n;
		for(int[] edge : edges) {
			if(union(edge[0], edge[1], parent, rank)) {
				result--;
			}
		}
		
		return result;
	}
	
	public int findParent(int vertex, int[] parent) {
		int curr = vertex;
		//until the curr and it's parent is not equal
		//we try to find it's parent
		while(curr != parent[curr]) {
			//updating parent with grand parent
			parent[curr] = parent[parent[curr]];
			curr = parent[curr];
		}
		return curr;
	}
	
	public boolean union(int vertex1, int vertex2, int[] parent, int[] rank) {
		int parent1 = findParent(vertex1, parent);
		int parent2 = findParent(vertex2, parent);
		
		//already connected vertices
		if(parent1 == parent2) return false;
		
		//if parent is less, explain this
		if (rank[parent1] > rank[parent2]) {
        int temp = parent1;
        parent1 = parent2;
        parent2 = temp;
    }
    parent[parent2] = parent1;
    rank[parent1] += rank[parent2];
    return true;
  }
}