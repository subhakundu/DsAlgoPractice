/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 */
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) {
            return true;
        }
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int[] edge: edges) {
            int first = edge[0];
            int second = edge[1];
            adjacencyList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjacencyList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.offer(source);
        boolean[] visited = new boolean[n];
        while(!bfsQueue.isEmpty()) {
            int currentNode = bfsQueue.poll();
            visited[currentNode] = true;
            if (currentNode == destination) {
                return true;
            }
            for (int neighbor: adjacencyList.getOrDefault(currentNode, Collections.emptyList())) {
                if (!visited[neighbor]) {
                    bfsQueue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return false;
    }
}
