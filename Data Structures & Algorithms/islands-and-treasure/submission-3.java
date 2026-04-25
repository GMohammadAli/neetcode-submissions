class Solution {
	private int INF = Integer.MAX_VALUE;
	private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
	public void islandsAndTreasure(int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 0) {
					queue.offer(new int[] {i ,j });
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int r = pos[0];
			int c = pos[1];
			
			for(int[] dir : directions) {
				int nR = r + dir[0];
				int nC = c + dir[1];
				
				if(nR < 0 || nR >= grid.length || nC < 0 || nC >= grid[0].length || grid[nR][nC] != INF) {
					continue;
				}
				
				grid[nR][nC] = grid[r][c] + 1;
				queue.offer(new int[]{nR, nC});
			}
		}
	}
}