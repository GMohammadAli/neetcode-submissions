class Solution {
    private int INF = Integer.MAX_VALUE;
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i, j, 0});
                    grid[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] currNode = queue.poll();
            int row = currNode[0];
            int col = currNode[1];
            int dist = currNode[2];

            for (int[] dir : directions) {
                int nR = dir[0] + row;
                int nC = dir[1] + col;

                if (nR < 0 || nC < 0 || nR >= grid.length || nC >= grid[nR].length
                    || grid[nR][nC] != INF)
                    continue;

                grid[nR][nC] = Math.min(grid[nR][nC], dist + 1);
                queue.offer(new int[] {nR, nC, grid[nR][nC]});
            }
        }
    }
}
