class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.offer(new int[] {0, 0, grid[0][0]});
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int row = cell[0];
            int col = cell[1];
            int currTime = cell[2];

            if(row == n - 1 && col == n - 1) return currTime;

            for (int[] dir : directions) {
                int nR = dir[0] + row;
                int nC = dir[1] + col;

                if (nR < 0 || nC < 0 || nR >= grid.length || nC >= grid[nR].length
                    || visited[nR][nC])
                    continue;
                
                visited[nR][nC] = true;
                minHeap.offer(new int[] {nR, nC, Math.max(currTime, grid[nR][nC])});
            }
        }

        return -1;
    }
}
