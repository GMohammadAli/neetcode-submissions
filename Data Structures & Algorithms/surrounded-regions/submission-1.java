class Solution {
    private int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] nonConnectedRegions = new boolean[ROWS][COLS];

        //left and right
        for(int j = 0; j < ROWS; j++) {
            dfs(j, 0, board, nonConnectedRegions);
            dfs(j, COLS - 1, board, nonConnectedRegions);
        }

        //top and bottom
        for(int i = 0; i < COLS; i++) {
            dfs(0, i, board, nonConnectedRegions);
            dfs(ROWS - 1, i, board, nonConnectedRegions);
        }

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(!nonConnectedRegions[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board, boolean[][] nonConnectedRegions) {
        if(board[row][col] == 'O') {
            nonConnectedRegions[row][col] = true;
        } else return;

        for(int[] dir : directions) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            if(newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[newRow].length || nonConnectedRegions[newRow][newCol]) {
                continue;
            }

            dfs(newRow, newCol, board, nonConnectedRegions);
        }
    }
}
