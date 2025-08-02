/**
 * https://leetcode.com/problems/number-of-closed-islands/description/
 */
class Solution {
    private boolean isLocked = true;
    public int closedIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length, count = 0;
        for(int i=1; i<row-1; i++) {
            for (int j=1; j<col-1; j++) {
                if (grid[i][j] == 0) {
                    isLocked = true;
                    isClosedIsland(grid, i, j, row, col);
                    if (isLocked) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private void isClosedIsland(int[][] grid, int x, int y, int row, int col) {
        if (((x==0 || x==row-1) || (y==0 || y==col-1)) && grid[x][y] == 0) {
            grid[x][y] = 2;
            isLocked = false;
        }
        grid[x][y] = 2;
        //System.out.println("ho 2: " + x + " " + y + grid[x][y]);
        int[] xCord = {-1, 1, 0, 0};
        int[] yCord = {0, 0, -1, 1};
        for(int i=0; i<4; i++) {
            int nX = x + xCord[i];
            int nY = y + yCord[i];
            if ((nX>=0 && nX<row) && (nY>=0 && nY<col) && grid[nX][nY] == 0) {
                isClosedIsland(grid, nX, nY, row, col);
            }
        }
    }

}
