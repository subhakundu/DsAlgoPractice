/**
 * https://leetcode.com/problems/number-of-closed-islands/
 * This is both time and space optimized. Here, we are using
 * same grid to identify if a cell is visited or not by modifying the cell to 1.
 * Because we do not care if a cell is modified. We only visit a cell once.
 */
class Solution {
    public int closedIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length, count = 0;
        for(int i=1; i<row-1; i++) {
            for (int j=1; j<col-1; j++) {
                if (grid[i][j] == 0) {
                    boolean isLocked = isClosedIsland(grid, i, j, row, col);
                    if (isLocked) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean isClosedIsland(int[][] grid, int x, int y, int row, int col) {
        if ((x < 0 || x >= row || y<0 || y>= col)) {
            return false;
        }
        if (grid[x][y] != 0) {
            return true;
        }
        if (grid[x][y] == 0) {
            grid[x][y] = 1;
        }
        int[] xCord = {-1, 1, 0, 0};
        int[] yCord = {0, 0, -1, 1};
        boolean isLocked= true;
        for(int i=0; i<4; i++) {
            int nX = x + xCord[i];
            int nY = y + yCord[i];
            // There might be cases, that from a particular point,
            // there are two branches. First branch leads to a edge cell. Then this branch of recursion will return false. Other branch will return true. 
            // In that case, we will ignore the fact of first false. Hence, we need to check if any previous branch has already been false. If yes,
            // then we ignore subsequent true.
            boolean isABranchLocked = isClosedIsland(grid, nX, nY, row, col);
            if (isLocked == true) {
                isLocked = isABranchLocked;
            }
        }
        return isLocked;
    }
}
