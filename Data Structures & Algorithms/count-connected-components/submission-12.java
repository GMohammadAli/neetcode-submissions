class Solution {
    public int countComponents(int n, int[][] edges) {
        // using union find
        int[] parent = new int[n];
        int[] rank = new int[n];

        // default values
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int numOfConnectedComponents = n;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (unionNMerge(parent, rank, u, v)) {
                numOfConnectedComponents--;
            }
        }

        return numOfConnectedComponents;
    }

    public int findParent(int u, int[] parent) {
        int curr = u;

        while(curr != parent[curr]) {
            parent[curr] = parent[parent[curr]];
            curr = parent[curr];
        }

        return curr;
    }

    public boolean unionNMerge(int[] parent, int[] rank, int u, int v) {
        int parentU = findParent(u, parent);
        int parentV = findParent(v, parent);

        if (parentU == parentV)
            return false;

        if (rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
            rank[parentU] += rank[parentV];
        } else {
            parent[parentU] = parentV;
            rank[parentV] += rank[parentU];
        }

        return true;
    }
}
