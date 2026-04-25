class Solution {

    public int countComponents(int n, int[][] edges) {

        // parent[i] = parent of vertex i
        int[] parent = new int[n];

        // rank[i] = size of component whose root is i
        int[] rank = new int[n];

        // initialize parent and rank arrays
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // initially each vertex is its own component
        int components = n;

        // process all edges
        for(int[] edge : edges) {

            // if union happens, components reduce
            if(union(edge[0], edge[1], parent, rank)) {
                components--;
            }
        }

        return components;
    }


    // find root parent using path compression
    public int findParent(int vertex, int[] parent) {

        int curr = vertex;

        while(curr != parent[curr]) {

            // path compression (point node to grandparent)
            parent[curr] = parent[parent[curr]];

            curr = parent[curr];
        }

        return curr;
    }


    // union two components using union by size
    public boolean union(int v1, int v2, int[] parent, int[] rank) {

        int p1 = findParent(v1, parent);
        int p2 = findParent(v2, parent);

        // already in same component
        if(p1 == p2) {
            return false;
        }

        // attach smaller component to larger component
        if(rank[p1] < rank[p2]) {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }

        return true;
    }
}