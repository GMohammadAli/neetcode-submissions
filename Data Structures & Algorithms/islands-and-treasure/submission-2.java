class Solution {
    int  INF = 2147483647;
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }


        int distance = 0;

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];

            // keep adding
            // next possible traverse-able places
            for(int[] dir : directions) {
                int nRow = r + dir[0];
                int nCol = c + dir[1];

                if (nRow >= grid.length || nCol >= grid[0].length || nRow < 0 ||
                    nCol < 0 || grid[nRow][nCol] != INF) {
                    continue;
                }
                queue.add(new int[] { nRow, nCol });

                grid[nRow][nCol] = grid[r][c] + 1;
            }
        }
    }
}
