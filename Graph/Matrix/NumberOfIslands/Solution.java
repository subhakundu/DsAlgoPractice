/**
 * https://leetcode.com/problems/number-of-islands/
 * Edge Cases: All 0, All 1, One row, One column, One element - zero, one
 * Pseudo Code:
 * 1. We need to start DFS for each new cell 1, count = 1
 * 2. In DFS - search horizontally and vertically (account for cells at edges)
 * 3. Whenever, we start DFS, increase count by 1 and set visited cells by -1.
 */
class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0, m = grid.length, n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    util(grid, i, j, m, n);
                }
            }
        }
        return numberOfIslands;
    }
    private void util(char[][] grid, int x, int y, int mX, int nY) {
        grid[x][y] = 'X';
        int [] xCord = {-1, 1, 0, 0};
        int [] yCord = {0, 0, 1, -1};
        for (int i=0; i<4; i++) {
            int newX = x + xCord[i];
            int newY = y + yCord[i];

            if ((newX>= 0 && newX<mX) && (newY>= 0 && newY<nY) && grid[newX][newY] == '1') {
                util(grid, newX, newY, mX, nY);
            }
        }
    }
}
