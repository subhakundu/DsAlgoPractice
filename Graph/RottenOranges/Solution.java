/**
 * https://leetcode.com/problems/rotting-oranges/
 * Initially my approach was to start the BFS from each rotten mangoes and count the number of times BFS was triggered. But that was wrong because
 * 1. It is same as the number of rotten oranges.
 * 2. It will not take into the fact that some orange can be destroyed
 * by another BFS.
 * Hence the algorithm is - start BFS from all the rooten mangoes at the 
 * same time. How to do that ? - offer all rotten mangoes initially. It 
 * will start BFS for all. We will store the size of each layer. Once it 
 * is 0, and we have destroyed mangoes, we increase the time.
 * We also track the number of mangoes destroyed. If it is not same as 
 * original count of fresh mangoes, we return -1. Else, we return the time 
 * which is same as the number of layers we visit in BFS.
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int minTime = -1;
        Queue<Pair> bfsQueue = new LinkedList<>();
        int [] xCord = {0, 0, 1, -1};
        int [] yCord = {1, -1, 0, 0};
        int freshCount = 0;

        for (int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if (grid[i][j] == 2) {
                   bfsQueue.offer(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        // We have to see how many fresh mangoes we can damage. If number does not match, we return -1, else the time.
        int time = 0;
        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            boolean orangesDestroyed = false;
            while(size>0) {
                Pair currentNode = bfsQueue.poll();
                int cX = currentNode.x, cY = currentNode.y;
                if (grid[cX][cY] == 1) {
                    grid[cX][cY] = 2;
                    freshCount--;
                    orangesDestroyed = true;
                }
                for (int i=0; i<4; i++) {
                    int newX = cX + xCord[i];
                    int newY = cY + yCord[i];
                    if ((newX>=0 && newX<row) && (newY>=0 && newY<col) && grid[newX][newY] == 1) {
                        bfsQueue.offer(new Pair(newX, newY));
                    }
                }
                size--;
            }
            if(orangesDestroyed) {
                time++;
            }
        }
        return freshCount==0 ? time : -1;
    }

    class Pair {
        int x;
        int y;
        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}
