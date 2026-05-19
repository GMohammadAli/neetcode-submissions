/**
 *  * const { MinPriorityQueue } = require('@datastructures-js/priority-queue');
 */

class Solution {
    /**
     * @param {number[][]} grid
     * @return {number}
     */
    swimInWater(grid) {
        const visit = new Set();
        const n = grid.length;
        const directions = [
            [0, 1],
            [1, 0],
            [-1, 0],
            [0, -1],
        ];

        const minHeap = new MinPriorityQueue((entry) => entry[0]);
        minHeap.push([grid[0][0], 0, 0]);
        visit.add("0,0");

        while (!minHeap.isEmpty()) {
            const [maxTime, row, col] = minHeap.pop();

            if (row === n - 1 && col === n - 1) return maxTime;

            for (const dir of directions) {
                const nR = dir[0] + row;
                const nC = dir[1] + col;

                if (nR < 0 || nC < 0 || nR >= n || nC >= n || visit.has(`${nR},${nC}`)) continue;

                visit.add(`${nR},${nC}`);
                minHeap.push([Math.max(maxTime, grid[nR][nC]), nR, nC]);
            }
        }

        return -1;
    }
}
