    class Solution {

        class DSU {
            int[] parent;
            int[] rank;

            DSU(int n) {
                parent = new int[n];
                rank = new int[n];
                for(int i = 0; i < n; i++) {
                    parent[i] = i;
                    rank[i] = 1;
                }
            }

            private int findParent(int vertex) {
                int curr = parent[vertex];
                while(curr != parent[curr]) {
                    parent[curr] = parent[parent[curr]];
                    curr = parent[curr];
                }
                return curr;
            }

            private boolean union(int u, int v) {
                int pu = this.findParent(u);
                int pv = this.findParent(v);

                if(pu == pv) {
                    //already connected
                    return false;
                }

                //whoever has more rank has a larger set (tree)
                //so, we merge into it
                if(rank[pu] >= rank[pv]) {
                    parent[pv] = pu;
                    rank[pu] += rank[pv];
                } else {
                    parent[pu] = pv;
                    rank[pv] += rank[pu];
                }

                return true;
            }
        }
        public int[] findRedundantConnection(int[][] edges) {
            //Using DSU find Algo
            int n = edges.length;
            DSU disjointUnionSet = new DSU(n+1);
            int[] result = new int[2];

            for(int[] edge: edges) {
                if(!disjointUnionSet.union(edge[0], edge[1])) {
                    //edges that cannot be unionized are said to form cycles
                    //why, because we already unionized them, when we encountered those 
                    //vertices in other edges, hence, they form a cycle
                    result[0] = edge[0];
                    result[1] = edge[1];
                }
            }

            return result;
        }
    }