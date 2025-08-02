 /**
 * https://leetcode.com/problems/surrounded-regions/description/
 * 1. We have to convert the cells from the O to X.
 * 2. We cannot convert if any cell is on the fence.
 * We can do in three passes - first convert boundary cells with O and corresponding regions, Then convert inner regions. Later convert boundary regions back to O.
 * It is O, not 0.
 */
class Solution {
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        for (int i=0; i<row; i++) {

            if (board[i][0] == 'O') {
                dfs(board, i, 0, row, col);
            }
        }
        for (int i=0; i<row; i++) {
            if (board[i][col-1] == 'O') {
                dfs(board, i, col-1, row, col);
            }
        }
        for (int i=0; i<col; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, row, col);
            }
        }
        for (int i=0; i<col; i++) {
            if (board[row-1][i] == 'O') {
                dfs(board, row-1, i, row, col);
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int x, int y, int row, int col) {
        board[x][y] = 'Y';
        int[] xCord = {-1, 1, 0, 0};
        int[] yCord = {0, 0, -1, 1};
        for (int i=0; i<4; i++) {
            int nX = x + xCord[i];
            int nY = y + yCord[i];
            if ((nX>=0 && nX<row) && (nY>=0 && nY<col) && (board[nX][nY] == 'O')) {
                dfs(board, nX, nY, row, col);
            }
        }
    }
}
