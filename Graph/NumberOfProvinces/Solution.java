/**
 * https://leetcode.com/problems/number-of-provinces/
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int nodes = isConnected.length;
        int numberOfProvinces = 0;
        boolean [] visited = new boolean[nodes];

        for (int i=0; i<nodes; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                numberOfProvinces++;
            }
        }
        return numberOfProvinces;
    }
    private void dfs(int[][] isConnected, int node, boolean[] visited) {
        visited[node] = true;
        for (int i=0; i<isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(isConnected, i, visited);
            }
        }
    }
}
