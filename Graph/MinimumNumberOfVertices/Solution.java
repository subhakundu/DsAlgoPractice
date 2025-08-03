/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/
 */
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasIncomingEdge = new boolean[n];
        for (List<Integer> edge: edges) {
            hasIncomingEdge[edge.get(1)] = true;
        }
        List<Integer> requiredNodes = new ArrayList();
        for (int i=0; i < n; i++) {
            if(!hasIncomingEdge[i]) {
                requiredNodes.add(i);
            }
        }
        return requiredNodes;
    }
}
