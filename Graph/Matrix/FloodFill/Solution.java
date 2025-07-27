/**
 * https://leetcode.com/problems/flood-fill/description/
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        int row = image.length, col = image[0].length, startingColor = image[sr][sc];
        int[] xCord = {1, -1, 0, 0};
        int[] yCord = {0, 0, 1, -1};
        Queue<Pair> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new Pair(sr, sc));
        while(!bfsQueue.isEmpty()) {
            Pair currentPair = bfsQueue.poll();
            int x = currentPair.xCord;
            int y = currentPair.yCord;
            if (image[x][y] != startingColor)  {
                continue;
            }
            image[x][y] = color;
            for (int i=0; i<4; i++) {
                int newX = x + xCord[i];
                int newY = y + yCord[i];
                if ((newX>=0 && newX<row) && (newY>=0 && newY<col)) {
                    bfsQueue.offer(new Pair(newX, newY));
                }
            }
        }
        return image;
    }
    private class Pair {
        int xCord;
        int yCord;
        Pair(int x, int y) {
            xCord = x;
            yCord = y;
        }
    }
}
