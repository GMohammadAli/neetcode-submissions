class Solution {
    /**
     * @param {number} n
     * @param {number[][]} edges
     * @returns {number}
     */
    countComponents(n, edges) {
        const graph = [];

        for(let i = 0; i < n; i++) {
            graph.push([]);
        }

        for(let i = 0; i < edges.length; i++) {
            let edge = edges[i];
            graph[edge[0]].push(edge[1]);
            graph[edge[1]].push(edge[0]);
        }

        const visited = new Set();
        let numOfConnectedComponents = 0;

        const dfs = (vertex) => {
            if(visited.has(vertex)) return;

            visited.add(vertex);
            let n = graph[vertex].length;
            for(let i = 0; i < n; i++) {
                let neighbor = graph[vertex][i];
                dfs(neighbor);
            }
        }

        for(let i = 0; i < n; i++) {
            if(visited.has(i)) continue;
            numOfConnectedComponents++;
            dfs(i);
        }

        return numOfConnectedComponents;
    }
}
