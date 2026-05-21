class Solution {
    /**
     * @param {number} n
     * @param {number[][]} flights
     * @param {number} src
     * @param {number} dst
     * @param {number} k
     * @return {number}
     */
    findCheapestPrice(n, flights, src, dst, k) {
        const MAX = Number.MAX_VALUE;
        const minPath = Array(n).fill(MAX);
        const graph = Array.from({ length: n }, () => []);

        for (const flight of flights) {
            graph[flight[0]].push([flight[1], flight[2]]);
        }

        const queue = [];
        queue.push([src, 0]);
        minPath[src] = 0;
        let stops = 0;

        while (queue.length != 0 && stops <= k) {
            const size = queue.length;

            for (let i = 0; i < size; i++) {
                const [stop, cost] = queue.shift();

                for (const neighbor of graph[stop]) {
                    const nextStop = neighbor[0];
                    const nextCost = cost + neighbor[1];
                    if (nextCost < minPath[nextStop]) {
                        minPath[nextStop] = nextCost;
                        queue.push([nextStop, nextCost]);
                    }
                }
            }

            stops++;
        }

        return minPath[dst] !== MAX ? minPath[dst] : -1;
    }
}
