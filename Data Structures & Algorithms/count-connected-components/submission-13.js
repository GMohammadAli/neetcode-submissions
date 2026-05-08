class Solution {
    /**
     * @param {number} n
     * @param {number[][]} edges
     * @returns {number}
     */
    countComponents(n, edges) {
        const parent = [];
        const rank = [];

        for(let i = 0; i < n; i++) {
            parent.push(i);
            rank.push(1);
        }

        const findParent = (vertex) => {
            let curr = vertex;

            while(curr != parent[curr]) {
                //2 jumps above
                parent[curr] = parent[parent[curr]];
                curr = parent[curr];
            }

            return curr;
        }

        const union = (u, v) => {
            const pU = findParent(u);
            const pV = findParent(v);

            if(pU == pV) return false;
            if(rank[pU] > rank[pV]) {
                parent[pV] = pU;
                rank[pU] += rank[pV];
            } else {
                parent[pU] = pV;
                rank[pV] += rank[pU];
            }

            return true;
        }

        
        let numOfConnected = n;
        for(let i = 0; i < edges.length; i++) {
            const edge = edges[i];
            if(union(edge[0], edge[1])) {
                numOfConnected--;
            }
        }

        return numOfConnected;
    }
}
